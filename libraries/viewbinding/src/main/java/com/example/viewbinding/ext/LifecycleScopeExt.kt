package com.example.viewbinding.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Flow<T>.launchWhenResumed(scope: LifecycleCoroutineScope): Job =
	scope.launchWhenResumed {
		collect()
	}

fun <T> Flow<T>.repeatWhenStarted(lifecycleOwner: LifecycleOwner) {
	lifecycleOwner.lifecycleScope.launch {
		lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
			collect()
		}
	}
}