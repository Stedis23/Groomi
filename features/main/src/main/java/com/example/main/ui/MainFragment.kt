package com.example.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.core.setOnBackPressedListener
import com.example.main.R
import com.example.main.databinding.FragmentMainBinding
import com.example.main.presentation.MainRouterName.MAIN
import com.example.main.presentation.MainScreenState
import com.example.navigation.GroomiKeepStateNavigator
import com.example.navigation.MAIN_KEY
import com.example.navigation.ScreenNameHolder
import androidx.fragment.app.setFragmentResultListener
import com.example.main.presentation.MainViewModel
import com.example.viewbinding.BindingFragment
import com.example.viewbinding.ext.launchWhenResumed
import com.github.terrakok.cicerone.NavigatorHolder
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class MainFragment :
	BindingFragment<FragmentMainBinding>(),
	ScreenNameHolder {

	override val screenName: String
		get() = when (binding.navigationBar  .selectedItemId) {
			R.id.main_menu_salons  -> getString(R.string.main_menu_salons)
			R.id.main_menu_profile -> getString(R.string.main_menu_profile)
			else                   -> throw IllegalArgumentException("Unknown last screen")
		}

	private val navigatorHolder: NavigatorHolder by inject(named(MAIN))
	private val viewModel: MainViewModel by viewModel()

	override fun otherSetups() {
		initCicerone()
		setOnBackPressedListener { viewModel.navigateBack() }
		setFragmentResultListener(MAIN_KEY) { _, bundle ->
			childFragmentManager.setFragmentResult(bundle.getString(MAIN_KEY).orEmpty(), bundle)
		}
	}

	private fun initCicerone() {
		val navigator = GroomiKeepStateNavigator(
			requireActivity(),
			R.id.host_main,
			childFragmentManager,
		)

		navigatorHolder.setNavigator(navigator)
		viewModel.currentScreenFlow.onEach {
			binding.navigationBar.selectedItemId = when (it) {
				MainScreenState.SALONS          -> R.id.main_menu_salons
				MainScreenState.PROFILE         -> R.id.main_menu_profile
				MainScreenState.LOGIN_SELECTION -> R.id.main_menu_profile
			}
		}.launchWhenResumed(viewLifecycleOwner.lifecycleScope)

		binding.navigationBar.setOnItemSelectedListener {
			when (it.itemId) {
				R.id.main_menu_salons -> viewModel.navigateToSalons()
				R.id.main_menu_profile        -> viewModel.navigateToProfile()
			}
			true
		}
	}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentMainBinding =
		FragmentMainBinding.inflate(inflater, container, false)

	override fun onDestroyView() {
		super.onDestroyView()
		navigatorHolder.removeNavigator()
	}

}