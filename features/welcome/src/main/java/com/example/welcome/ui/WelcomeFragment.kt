package com.example.welcome.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.core.getColorFromAttr
import com.example.core.setOnBackPressedListener
import com.example.navigation.ScreenNameHolder
import com.example.viewbinding.BindingFragment
import com.example.welcome.R
import com.example.welcome.databinding.FragmentWelcomeBinding
import com.example.welcome.presentation.WelcomeViewModel
import com.example.welcome.ui.viewpager.RecyclerViewAdapter
import com.example.welcome.ui.viewpager.Slide
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import com.example.theme.R as ThemeR

class WelcomeFragment:
	BindingFragment<FragmentWelcomeBinding>(),
	ScreenNameHolder {

	companion object{

		private const val FIRST_ITEM = 0
	}

	private val slideDataSet = arrayOf(
		Slide(
			image = ThemeR.drawable.ic_we_groomi,
			title = R.string.welcome_page_greetings_title,
			description = R.string.welcome_page_greetings_description
		),
		Slide(
			image = ThemeR.drawable.ic_we_groomi,
			title = R.string.welcome_page_hairdressing_salon_title,
			description = R.string.welcome_page_hairdressing_salon_description
		),
		Slide(
			image = ThemeR.drawable.ic_we_groomi,
			title = R.string.welcome_page_beauty_salon_title,
			description = R.string.welcome_page_beauty_salon_description
		),
		Slide(
			image = ThemeR.drawable.ic_we_groomi,
			title = R.string.welcome_page_service_title,
			description = R.string.welcome_page_service_description
		),
	)

	private val viewModel: WelcomeViewModel by viewModel()
	private val adapter: RecyclerViewAdapter by inject(parameters = { parametersOf(slideDataSet) })

	override val screenName: String
		get() = getString(R.string.welcome_home)

	override fun otherSetups() {
		setupsDots()
		setupsContent()
		initButtons()
		setOnBackPressedListener {
			if (binding.content.currentItem == 0) {
				viewModel.navigateBack()
			} else {
				binding.content.currentItem--
			}
		}
	}

	private fun setupsDots() {
		binding.dotsContainer.removeAllViews()
		for (slide in slideDataSet.indices) {
			binding.dotsContainer.addView(
				TextView(requireContext()).apply {
					setTextColor(
						getColorFromAttr(
							if (slide == FIRST_ITEM) {
								androidx.appcompat.R.attr.colorPrimary
							} else {
								com.google.android.material.R.attr.colorSecondaryVariant
							}
						)
					)
					text = getString(R.string.welcome_dot)
					textSize = 45F
				}
			)
		}
	}

	private fun setupsContent() {
		binding.content.adapter = adapter
		binding.content.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				super.onPageSelected(position)
				changeDot(position)
				binding.signUpButton.visibility = if (position == slideDataSet.size - 1) {
					View.VISIBLE
				} else {
					View.INVISIBLE
				}
			}
		})
	}

	private fun changeDot(position: Int) {
		for (slide in slideDataSet.indices) {
			(binding.dotsContainer.getChildAt(slide) as TextView)
				.setTextColor(
					getColorFromAttr(
						if (slide == position) {
							androidx.appcompat.R.attr.colorPrimary
						} else {
							com.google.android.material.R.attr.colorSecondaryVariant
						}
					)
				)
		}
	}

	private fun initButtons() {
		binding.signUpButton.setOnClickListener {
			viewModel.navigateToRegistration()
		}
		binding.skipAllButton.setOnClickListener {
			viewModel.navigateToMain()
		}
	}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentWelcomeBinding =
		FragmentWelcomeBinding.inflate(inflater, container, false)
}