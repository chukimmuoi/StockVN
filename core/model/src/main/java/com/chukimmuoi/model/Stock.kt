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
data class Stock(
    val code: String = "",
    val type: String = "",
    val floor: String = "",
    val status: String = "",
    val companyName: String = "",
    val companyNameEng: String = "",
    val shortName: String = "",
    val listedDate: String = "",
    val deListedDate: String = "",
    val companyId: String = "",
    var isBookmarked: Boolean = false,
    var isPurchased: Boolean = false,
    val indexCode: String = "",
    val isIn: String = ""
)

val previewStocks = listOf(
    Stock(
        code = "SFN",
        type = "STOCK",
        floor = "HNX",
        isIn = "VN000000SFN8",
        status = "listed",
        companyName = "Công ty Cổ phần Dệt lưới Sài Gòn ",
        companyNameEng = "Saigon Fishing Net Joint Stock Company",
        shortName = "Dệt lưới Sài Gòn",
        listedDate = "2009-06-12",
        companyId = "1352"
    ),
    Stock(
        code = "AME",
        type = "STOCK",
        floor = "HNX",
        isIn = "VN000000AME1",
        status = "listed",
        companyName = "Công ty Cổ phần Alphanam E&C",
        companyNameEng = "Alphanam E&C Joint Stock Company",
        shortName = "Alphanam E&C",
        listedDate = "2010-06-02",
        companyId = "2796"
    ),
    Stock(
        code = "LCS",
        type = "STOCK",
        floor = "HNX",
        isIn = "VN000000LCS9",
        status = "listed",
        companyName = "Công ty Cổ phần Licogi 166 ",
        companyNameEng = "Licogi 16.6 Joint Stock Company",
        shortName = "CTCP Licogi 166",
        listedDate = "2010-07-06",
        companyId = "2791"
    ),
    Stock(
        code = "DHP",
        type = "STOCK",
        floor = "HNX",
        isIn = "VN000000DHP1",
        status = "listed",
        companyName = "Công ty Cổ phần Điện Cơ Hải Phòng",
        companyNameEng = "Hai Phong Electrical Mechanical Joint Stock Company",
        shortName = "Điện Cơ Hải Phòng",
        listedDate = "2013-03-21",
        companyId = "3673"
    ),
    Stock(
        code = "DAD",
        type = "STOCK",
        floor = "HNX",
        isIn = "VN000000DAD2",
        status = "listed",
        companyName = "Công ty Cổ phần Đầu tư và Phát triển giáo dục Đà Nẵng ",
        companyNameEng = "Da Nang Education Development And Investment Joint Stock Company",
        shortName = "ĐTPT Giáo dục ĐN",
        listedDate = "2009-08-19",
        companyId = "2513"
    )
)
