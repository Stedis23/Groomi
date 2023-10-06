package com.example.network.utils.fake

internal class RegexPath(val path: Regex) {

	constructor(path: String) : this(path.toRegex())

	override fun equals(other: Any?): Boolean {
		if (other === null) return false
		if (this === other) return true
		if (other !is RegexPath) return false

		return other.path.matches(path.toString())
	}

	override fun hashCode(): Int =
		path.hashCode()
}