package com.chukimmuoi.stockvn.support.log

import android.util.Log
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
class ReleaseTree: Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Log.i("Nothing", "Don't care!")
    }
}