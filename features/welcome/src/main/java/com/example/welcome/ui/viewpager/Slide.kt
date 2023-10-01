package com.example.welcome.ui.viewpager

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class Slide(
	@DrawableRes val image: Int,
	@StringRes val title: Int,
	@StringRes val description: Int
)