package com.example.homesalons.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.homesalons.databinding.FragmentHomeSalonsBinding
import com.example.homesalons.presentation.HomeSalonsViewModel
import com.example.viewbinding.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeSalonsFragment :
	BindingFragment<FragmentHomeSalonsBinding>() {

	private val viewModel: HomeSalonsViewModel by viewModel()

	override fun otherSetups() {

	}

	override fun binding(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	) = FragmentHomeSalonsBinding.inflate(inflater, container, false)
}