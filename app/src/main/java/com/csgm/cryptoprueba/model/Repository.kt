package com.csgm.cryptoprueba.model

import android.util.Log
import com.csgm.cryptoprueba.model.client.RetrofitClient
import com.csgm.cryptoprueba.model.remote.CryptoAPI
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class Repository {

    private val cryptoAPI: CryptoAPI = RetrofitClient.instance()

    suspend fun getAssets(): CryptoResponse {
        try {
            val response = cryptoAPI.getAssets()
            if (response.isSuccessful) {
                val cryptoResponse = response.body()
                if (cryptoResponse != null) {
                    Log.d("Repository", "Response: $cryptoResponse")
                    return cryptoResponse
                }
            }
            // Manejar la respuesta si no fue exitosa
            throw IOException("Error al obtener los activos")
        } catch (e: HttpException) {
            // Manejar errores HTTP
            throw e
        } catch (e: IOException) {
            // Manejar errores de red
            throw e
        }
    }

    suspend fun getAssetDetail(id: String): AssetDetail {
        try {
            val response = cryptoAPI.getAssetDetail(id)
            if (response.isSuccessful) {
                val assetDetailResponse = response.body()
                if (assetDetailResponse != null) {
                    Log.d("Repository", "Response: $assetDetailResponse")
                    return assetDetailResponse
                }
            }
            // Manejar la respuesta si no fue exitosa
            throw IOException("Error al obtener el detalle del activo")
        } catch (e: HttpException) {
            // Manejar errores HTTP
            throw e
        } catch (e: IOException) {
            // Manejar errores de red
            throw e
        }
    }

    fun getImageFromSymbol(symbol: String) =
        "https://static.coincap.io/assets/icons/${symbol.lowercase(Locale.ROOT)}@2x.png"


}