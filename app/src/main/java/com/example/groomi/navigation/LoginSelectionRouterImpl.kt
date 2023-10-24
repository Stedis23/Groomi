package com.example.groomi.navigation

import com.example.loginselection.presentation.LoginSelectionRouter
import com.example.navigation.GlobalRouter
import com.example.signin.SignInDestination
import com.example.signup.SignUpDestination

class LoginSelectionRouterImpl(
	private val router: GlobalRouter,
) : LoginSelectionRouter {

	override fun navigateToSignUp() {
		router.open(SignUpDestination)
	}

	override fun navigateToSingIn() {
		router.open(SignInDestination)
	}
}

