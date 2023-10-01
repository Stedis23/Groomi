package com.example.welcome.domain.datasource

interface SkipWelcomeSharedPrefDataSource {

	fun insert()

	fun get(): Boolean
}