package com.chukimmuoi.data.api

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit


/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 15/09/2022.
 */
class CacheInterceptor: Interceptor {

    companion object {
        const val HOST_HEADER = "Host"
        const val CONNECTION_HEADER = "Connection"
        const val ACCEPT_ENCODING_HEADER = "Accept-Encoding"
        const val USER_AGENT_HEADER = "User-Agent"
        const val DATE_HEADER = "Date"
        const val CONTENT_TYPE_HEADER = "Content-Type"
        const val TRANSFER_ENCODING_HEADER = "Transfer-Encoding"
        const val VARY_HEADER = "Vary"
        const val X_REQUEST_ID_HEADER = "x-request-id"
        const val SERVER_HEADER = "Server"
        const val EXPIRES_HEADER = "Expires"
        const val CACHE_CONTROL_HEADER = "Cache-Control"
        const val X_PROXY_CACHE_HEADER = "X-Proxy-Cache"
        const val PRAGMA_HEADER = "Pragma"
        const val ACAO_HEADER = "Access-Control-Allow-Origin"
        const val ACAC_HEADER = "Access-Control-Allow-Credentials"
        const val ACAM_HEADER = "Access-Control-Allow-Methods"
        const val ACAH_HEADER = "Access-Control-Allow-Headers"
        const val AUTHORIZATION_HEADER = "Authorization"
        const val COOKIE_HEADER = "Cookie"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder().build()

        val cacheControl = CacheControl.Builder()
            .maxAge(7, TimeUnit.DAYS)
            .build()
        val requestBuilder = original.newBuilder()
            .header(CACHE_CONTROL_HEADER, cacheControl.toString())
            .addHeader(CONTENT_TYPE_HEADER, "application/json")
            //.addHeader(USER_AGENT_HEADER, "")
            //.addHeader("AUTHORIZATION_HEADER", "")
            //.addHeader("COOKIE_HEADER", "ss-id=")
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}