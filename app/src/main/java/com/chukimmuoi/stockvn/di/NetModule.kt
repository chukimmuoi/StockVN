package com.chukimmuoi.stockvn.di

import android.app.Application
import com.chukimmuoi.data.api.CacheInterceptor
import com.chukimmuoi.data.api.ForceCacheInterceptor
import com.chukimmuoi.data.api.StockApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 10/09/2022.
 */
/**
 * @see [blog.mindorks.com](https://blog.mindorks.com/okhttp-interceptor-making-the-most-of-it)
 * @see [amitshekhar.me](https://amitshekhar.me/blog/caching-with-okhttp-interceptor-and-retrofit?fbclid=IwAR0FlR51QFl6Vp8RbOpkyfXxet3JegG8Djgs8BTlHDlTw9gjNhf6y1wYES8)
 * @see [blog.mindorks.com](https://blog.mindorks.com/how-to-enable-logging-in-okhttp)
 *
 * @see [guides.codepath.com](https://guides.codepath.com/android/Using-OkHttp)
 * @see [guides.codepath.com](https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2)
 * @see [guides.codepath.com](https://guides.codepath.com/android/Consuming-APIs-with-Retrofit)
 *
 * */
@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    companion object {

        private const val BASE_URL = "https://finfo-api.vndirect.com.vn/v4/"

        private const val VALUES_ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

        private const val VALUES_CONNECT_TIMEOUT = 15L
        private const val VALUES_READ_TIMEOUT = 15L
        private const val VALUES_WRITE_TIMEOUT = 15L
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): StockApi {

        return retrofit.create(StockApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {

        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {

        return GsonBuilder()
            .setDateFormat(VALUES_ISO_FORMAT)
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @Named("CacheInterceptor")
        cacheInterceptor: Interceptor,
        @Named("ForceCacheInterceptor")
        forceCacheInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(forceCacheInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(cacheInterceptor)
            .connectTimeout(VALUES_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(VALUES_READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(VALUES_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    @Named("CacheInterceptor")
    fun provideCacheInterceptor() : Interceptor {

        return CacheInterceptor()
    }

    @Singleton
    @Provides
    @Named("ForceCacheInterceptor")
    fun provideForceCacheInterceptor(
        application: Application
    ) : Interceptor {

        return ForceCacheInterceptor(application)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {

        return HttpLoggingInterceptor { Timber.i(it) }
            .apply {
                setLevel(HttpLoggingInterceptor.Level.HEADERS)
                redactHeader(CacheInterceptor.AUTHORIZATION_HEADER)
                redactHeader(CacheInterceptor.COOKIE_HEADER)
            }
    }

    @Singleton
    @Provides
    fun provideOkHttpCache(application: Application): Cache {
        val valuesCacheOkHttp = 10 * 1024 * 1024L // 10 MiB

        return Cache(application.cacheDir, valuesCacheOkHttp)
    }
}