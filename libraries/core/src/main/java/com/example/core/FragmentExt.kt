package com.example.core

import androidx.fragment.app.Fragment
import androidx.activity.addCallback
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

fun Fragment.setOnBackPressedListener(listener: () -> Unit) {
	requireActivity()
		.onBackPressedDispatcher
		.addCallback(viewLifecycleOwner) {
			listener()
		}
}

@ColorInt
fun Fragment.getColorFromAttr(@AttrRes attributeColor: Int): Int = requireContext().getColorFromAttr(attributeColor)