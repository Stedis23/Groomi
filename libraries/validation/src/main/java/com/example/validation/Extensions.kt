package com.example.validation

import android.widget.EditText
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.viewbinding.checkRunOnMain
import com.example.viewbinding.ext.asFlow
import com.example.viewbinding.ext.launchWhenResumed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach

inline fun <reified State : ValidationState, reified Item : ValidationItem<State>> EditText.bindValidator(
	scope: LifecycleCoroutineScope,
	flow: MutableStateFlow<Item>,
	crossinline validate: (String) -> Unit
) {
	checkRunOnMain()
	flow.filter { it.data != text?.toString() }
		.onEach {
			setText(it.data)
		}.launchWhenResumed(scope)
	asFlow()
		.filter {
			it != flow.value.data
		}.onEach {
			validate(it)
		}.launchWhenResumed(scope)
}