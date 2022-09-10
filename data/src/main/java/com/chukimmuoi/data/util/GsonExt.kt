package com.chukimmuoi.data.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 28/08/2022.
 */
// Transform simple object to String with Gson
inline fun <reified T : Any> T.toJson(): String = Gson().toJson(this, T::class.java)

// Transform String Json to Object
inline fun <reified T : Any> String.fromJson(): T = Gson().fromJson(this, T::class.java)

// Transform String List Json to Object
inline fun <reified T : Any> String.fromJsonList(): MutableList<T> =
    when (this.isNotEmpty()) {
        true -> Gson().fromJson(this, object : TypeToken<MutableList<T>>() {}.type)
        false -> mutableListOf()
    }