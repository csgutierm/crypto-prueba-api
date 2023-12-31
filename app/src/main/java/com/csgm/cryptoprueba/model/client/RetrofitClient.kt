package com.csgm.cryptoprueba.model.client

import com.csgm.cryptoprueba.model.remote.CryptoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.coincap.io/v2/"
class RetrofitClient {
    companion object {
/*        val apiService: CryptoAPI by lazy {
            instance().create(CryptoAPI::class.java)
        }*/
        fun instance(): CryptoAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(CryptoAPI::class.java)
        }
    }
}