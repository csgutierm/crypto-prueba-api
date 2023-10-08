package com.csgm.cryptoprueba.model

data class Asset(
    val id: String,
    val symbol: String,
    val name: String,
    val priceUsd: String,
    val changePercent24Hr: String
)
