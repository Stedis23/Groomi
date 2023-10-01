package com.example.groomi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groomi.navigation.GlobalRouterName.GLOBAL
import com.example.groomi.presentation.MainViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.navigation.GroomiAppNavigator
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

	private val navigatorHolder: NavigatorHolder by inject(named(GLOBAL))
	private val navigator = GroomiAppNavigator(this, R.id.host_global)
	private val viewModel: MainViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onResume() {
		super.onResume()
		navigatorHolder.setNavigator(navigator)
		viewModel.openMainRoot()
	}

	override fun onPause() {
		super.onPause()
		navigatorHolder.removeNavigator()
	}
}