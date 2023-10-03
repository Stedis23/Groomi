package com.example.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.profile.databinding.FragmentProfileBinding
import com.example.viewbinding.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>() {

	override fun otherSetups() {}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentProfileBinding =
		FragmentProfileBinding.inflate(inflater, container, false)
}