package com.chukimmuoi.stockvn

import android.app.Application
import androidx.work.Configuration
import com.chukimmuoi.stockvn.support.log.DebugTree
import com.chukimmuoi.stockvn.support.log.ReleaseTree
import com.chukimmuoi.stockvn.support.screen.getScreenType
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import android.util.Log
import com.chukimmuoi.stockvn.presentation.screen.stockprice.work.WorkerManagerFactory
import java.util.concurrent.Executors
import javax.inject.Inject

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
class StockApplication: Application(), Configuration.Provider  {

    @Inject lateinit var workerManagerFactory: WorkerManagerFactory

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

    override fun getWorkManagerConfiguration(): Configuration {


        return Configuration.Builder()
            .apply {
                if (BuildConfig.DEBUG) setMinimumLoggingLevel(Log.INFO)

                setWorkerFactory(workerManagerFactory)
                setExecutor(Executors.newFixedThreadPool(8))
            }
            .build()
    }
}