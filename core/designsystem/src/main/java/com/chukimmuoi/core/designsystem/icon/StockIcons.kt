package com.chukimmuoi.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 22/11/2022.
 */
object StockIcons {
    val Timeline = Icons.Rounded.Timeline
    val ArrowBack = Icons.Rounded.ArrowBack
    val Search = Icons.Rounded.Search
    val Bookmark = Icons.Rounded.Bookmark
    val BookmarkBorder = Icons.Rounded.BookmarkBorder
    val Home = Icons.Rounded.Home
    val HotelClass = Icons.Rounded.HotelClass
    val StarBorderPurple500 = Icons.Rounded.StarBorderPurple500
    val Check = Icons.Rounded.Check
    val ArrowDropDown = Icons.Rounded.ArrowDropDown
    val ArrowDropUp = Icons.Rounded.ArrowDropUp
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}