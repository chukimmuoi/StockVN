package com.chukimmuoi.stockvn

import android.app.Application
import com.chukimmuoi.stockvn.support.log.DebugTree
import com.chukimmuoi.stockvn.support.log.ReleaseTree
import com.chukimmuoi.stockvn.support.screen.getScreenType
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 02/09/2022.
 */
@HiltAndroidApp
class StockApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        getInfoScreen()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private fun getInfoScreen(): String {

        return resources.getScreenType()
    }
}