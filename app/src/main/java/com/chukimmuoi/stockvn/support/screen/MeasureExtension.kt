package com.chukimmuoi.stockvn.support.screen

import android.content.res.Resources
import timber.log.Timber

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 17/09/2022.
 */
/**
 * @see [Screen Densities](https://developer.android.com/training/multiscreen/screendensities)
 * 3:4:6:8:12:16 scaling ratio
 * 36x36   (0.75x) for low-density (ldpi)
 * 48x48   (1.0x baseline) for medium-density (mdpi)
 * 72x72   (1.5x) for high-density (hdpi)
 * 96x96   (2.0x) for extra-high-density (xhdpi)
 * 144x144 (3.0x) for extra-extra-high-density (xxhdpi)
 * 192x192 (4.0x) for extra-extra-extra-high-density (xxxhdpi)
 * */
fun Resources.getScreenType(): String {
    val density = this.displayMetrics.density
    val densityDpi = this.displayMetrics.densityDpi
    var output = "density = $density, densityDpi = $densityDpi"

    val widthFullScreen = displayMetrics.widthPixels
    val heightFullScreen = displayMetrics.heightPixels

    when {
        density <= 0.75F -> output = "ldpi"
        density <= 1.0F -> output = "mdpi"
        density <= 1.5F -> output = "hdpi"
        density <= 2.0F -> output = "xhdpi"
        density <= 3.0F -> output = "xxhdpi"
        density <= 4.0F -> output = "xxxhdpi"
        else -> "UnKnown Screen!"
    }
    Timber.i(
        "Screen Info:\n" +
                "density = $density,\n" +
                "densityDpi = $densityDpi dpi,\n" +
                "Screen: $output,\n" +
                "Width Full Screen = $widthFullScreen,\n" +
                "Height Full Screen = $heightFullScreen,\n"
    )
    return output
}