package com.csgm.cryptoprueba.model.remote

import com.csgm.cryptoprueba.model.AssetDetail
import com.csgm.cryptoprueba.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {
    @GET("assets")
    suspend fun getAssets(): Response<CryptoResponse>
    @GET("assets/{id}")
    suspend fun getAssetDetail(@Path("id") id:String): Response<AssetDetail>
}