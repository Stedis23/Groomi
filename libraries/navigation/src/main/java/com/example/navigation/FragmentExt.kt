package com.example.navigation

import androidx.fragment.app.Fragment

inline fun <reified T : Any> Fragment.getArgument(key: String, errorMessage: String? = null) =
	(arguments?.get(key) as T?) ?: throw IllegalArgumentException(errorMessage)

inline fun <reified T : Any> Fragment.getArgumentOrNull(key: String) =
	arguments?.get(key) as T?
