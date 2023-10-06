package ru.shiftlab.cftteam.shared.network.token.data.repository

import retrofit2.HttpException
import com.example.data.datasource.LocalTokenDataSource
import com.example.data.datasource.RemoteTokenDataSource
import ru.shiftlab.cftteam.shared.network.token.data.mapper.toDto
import ru.shiftlab.cftteam.shared.network.token.data.mapper.toRefreshTokenDto
import com.example.domain.entity.TokenBundleEntity
import com.example.domain.repository.TokenRepository
import com.example.network.utils.Exception.NetworkCode

class TokenRepositoryImpl(
	private val localTokenDataSource: LocalTokenDataSource,
	private val remoteTokenDataSource: RemoteTokenDataSource
) : TokenRepository {

	override suspend fun updateAccessToken(): String {
		try {
			val refreshToken = localTokenDataSource.getRefreshToken()
			val newTokenBundle = remoteTokenDataSource.refresh(refreshToken.toRefreshTokenDto())
			localTokenDataSource.saveTokenBundle(newTokenBundle)
			return newTokenBundle.accessToken
		} catch (httpException: HttpException) {
			if (httpException.code() == NetworkCode.UNAUTHORIZED) {
				localTokenDataSource.clear()
			}
			throw httpException
		}
	}

	override fun getAccessToken(): String = localTokenDataSource.getAccessToken()

	override fun checkTokenExists(): Boolean = localTokenDataSource.checkTokenExist()

	override fun saveTokenBundle(tokenBundleEntity: TokenBundleEntity) {
		localTokenDataSource.saveTokenBundle(tokenBundleEntity.toDto())
	}

	override fun clearTokenBundle() {
		localTokenDataSource.clear()
	}
}