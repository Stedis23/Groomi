package com.example.network.utils.fake.ext

import com.example.network.utils.fake.RegexPath

internal fun String.toRegexPath() =
	RegexPath(this)