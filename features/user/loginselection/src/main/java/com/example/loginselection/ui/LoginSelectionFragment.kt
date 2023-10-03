package com.example.loginselection.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.loginselection.databinding.FragmentLoginSelectionBinding
import com.example.viewbinding.BindingFragment

class LoginSelectionFragment : BindingFragment<FragmentLoginSelectionBinding>() {

	override fun otherSetups() {}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentLoginSelectionBinding =
		FragmentLoginSelectionBinding.inflate(inflater, container, false)
}