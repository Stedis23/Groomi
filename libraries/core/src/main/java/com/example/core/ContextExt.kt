package com.example.core

import android.content.Context
import android.util.TypedValue

fun Context.getColorFromAttr(attr: Int): Int = TypedValue().apply {
	theme.resolveAttribute(attr, this, true)
}.data