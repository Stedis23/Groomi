package com.example.loginselection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.loginselection.databinding.FragmentLoginSelectionBinding
import com.example.loginselection.presentation.LoginSelectionViewModel
import com.example.viewbinding.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginSelectionFragment : BindingFragment<FragmentLoginSelectionBinding>() {

	private val viewModel: LoginSelectionViewModel by viewModel()

	override fun otherSetups() {
		binding.signUpButton.setOnClickListener {
			viewModel.navigateToSignUp()
		}

		binding.signInButton.setOnClickListener {
			viewModel.navigateToSingIn()
		}
	}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentLoginSelectionBinding =
		FragmentLoginSelectionBinding.inflate(inflater, container, false)
}