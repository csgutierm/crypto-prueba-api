package com.csgm.cryptoprueba.model.remote

import com.csgm.cryptoprueba.model.Asset
import com.csgm.cryptoprueba.model.AssetDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {
    @GET("assets")
    suspend fun getAssets(): Response<List<Asset>>
    @GET("assets/{id}")
    suspend fun getAssets(@Path("id") id:String): Response<AssetDetail>
}