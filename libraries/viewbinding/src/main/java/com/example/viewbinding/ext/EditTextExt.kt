package com.example.viewbinding.ext

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.example.viewbinding.checkRunOnMain
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun EditText.asFlow(): Flow<String> = callbackFlow {
	checkRunOnMain()
	val watcher = doAfterTextChanged { trySend(it?.toString() ?: "").isSuccess }
	awaitClose { removeTextChangedListener(watcher) }
}