package com.example.viewbinding

import android.os.Looper

fun checkRunOnMain() =
	check(Looper.myLooper() == Looper.getMainLooper()) {
		"flow binding run in ${Thread.currentThread().name}, but must be in main"
	}