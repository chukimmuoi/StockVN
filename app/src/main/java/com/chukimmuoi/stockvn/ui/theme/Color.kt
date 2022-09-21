package com.chukimmuoi.stockvn.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFB39DDB)
val Purple300 = Color(0xFF9575CD)
val Purple700 = Color(0xFF512DA8)
val Purple800 = Color(0xFF4527A0)
val Purple900 = Color(0xFF311B92)

val BlueGrey900 = Color(0xFF263238)
val Grey100 = Color(0xFFF5F5F5)

val Colors.appThemeColor
    get() = if (isLight) Color.White else Color.Black

val Colors.appContentColor
    get() = if (isLight) Color.Black else Color.White

val Colors.titleColor
    get() = if (isLight) Color.Black else Color.White

val Colors.itemBackgroundColor get() = if (isLight) Grey100 else BlueGrey900