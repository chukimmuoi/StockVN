package com.chukimmuoi.model

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 05/12/2022.
 */
data class ChangePrice(
    val code: String = "",
    val bopPrice: Double = 0.0,
    val change: Double = 0.0,
    val changePct: Double = 0.0,
    val lastUpdated: String = "",
    val name: String = "",
    val period: String = "",
    val price: Double = 0.0,
    val type: String = ""
)

val previewChangePrice = listOf(
    ChangePrice(
        code = "HNX",
        name = "HNX",
        type = "INDEX",
        period = "1D",
        price = 242.119899,
        bopPrice = 235.611013,
        change = 6.508886,
        changePct = 2.7625559251765535,
        lastUpdated = "2022-10-05 15:10"
    ),
    ChangePrice(
        code = "UPCOM",
        name = "UPCOM",
        type = "INDEX",
        period = "1D",
        price = 83.786204,
        bopPrice = 82.375051,
        change = 1.411153,
        changePct = 1.7130830061640872,
        lastUpdated = "2022-10-05 15:10"
    ),
    ChangePrice(
        code = "VNINDEX",
        name = "VNINDEX",
        type = "INDEX",
        period = "1D",
        price = 1104.26,
        bopPrice = 1078.14,
        change = 26.12,
        changePct = 2.4226909306769064,
        lastUpdated = "2022-10-05 15:10"
    ),
    ChangePrice(
        code = "VN30",
        name = "VN30",
        type = "INDEX",
        period = "1D",
        price = 1117.38,
        bopPrice = 1097.72,
        change = 19.66,
        changePct = 1.7909849506249316,
        lastUpdated = "2022-10-05 15:10"
    ),
    ChangePrice(
        code = "VN30F1M",
        name = "Hợp đồng tương lai chỉ số VN30 tháng gần nhất",
        type = "FU",
        period = "1D",
        price = 1115.2,
        bopPrice = 1102.0,
        change = 13.2,
        changePct = 1.1978221415607986,
        lastUpdated = "2022-10-05 15:10"
    )
)
