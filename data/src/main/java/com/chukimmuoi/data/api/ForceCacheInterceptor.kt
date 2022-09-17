package com.chukimmuoi.data.api

import android.content.Context
import com.chukimmuoi.data.util.isInternetAvailable
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 15/09/2022.
 */
class ForceCacheInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val builder: Request.Builder = request.newBuilder()
        if (!context.isInternetAvailable()) {
            builder.cacheControl(CacheControl.FORCE_CACHE)
        }

        return chain.proceed(builder.build())
    }
}