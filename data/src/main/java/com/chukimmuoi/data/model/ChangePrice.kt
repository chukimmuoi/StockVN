package com.chukimmuoi.data.model


import com.google.gson.annotations.SerializedName

data class ChangePrice(
    @SerializedName("bopPrice")
    val bopPrice: Double = 0.0,
    @SerializedName("change")
    val change: Double = 0.0,
    @SerializedName("changePct")
    val changePct: Double = 0.0,
    @SerializedName("code")
    val code: String = "",
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("period")
    val period: String = "",
    @SerializedName("price")
    val price: Double = 0.0,
    @SerializedName("type")
    val type: String = ""
)