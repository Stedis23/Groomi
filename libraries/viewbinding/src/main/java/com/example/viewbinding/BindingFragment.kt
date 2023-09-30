package com.example.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.viewbinding.ext.closeKeyboard

abstract class BindingFragment<VB : ViewBinding> : Fragment(){

	private var _binding: VB? = null
	val binding = _binding ?: throw NullPointerException("Binding can't be null")

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?{
		_binding = binding(inflater, container, savedInstanceState)
		otherSetups()
		return _binding?.root
	}

	protected abstract fun binding(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): VB

	protected open fun otherSetups() {}

	override fun onPause() {
		closeKeyboard(binding)
		super.onPause()
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}