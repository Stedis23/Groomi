package ru.shiftlab.cftteam.libraries.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

interface FragmentResultContract<T> {

	val requestKey: String

	fun setResult(result: T): Bundle
	fun getResult(bundle: Bundle): T
}

const val MAIN_KEY = "MAIN_KEY"

fun <T> Fragment.setFragmentResult(contract: FragmentResultContract<T>, result: T) {
	parentFragmentManager.setFragmentResult(contract.requestKey, contract.setResult(result))
	parentFragmentManager.setFragmentResult(
		MAIN_KEY,
		contract.setResult(result).apply { putString(MAIN_KEY, contract.requestKey) }
	)
}

fun <T> Fragment.setFragmentResultListener(contract: FragmentResultContract<T>, listener: (T) -> Unit) {
	parentFragmentManager.setFragmentResultListener(contract.requestKey, viewLifecycleOwner) { _, bundle ->
		listener(contract.getResult(bundle))
	}
}