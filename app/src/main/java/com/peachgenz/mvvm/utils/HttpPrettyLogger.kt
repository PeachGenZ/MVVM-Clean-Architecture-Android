package com.peachgenz.mvvm.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class HttpPrettyLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        if (message.startsWith("{") || message.startsWith("[")) {
            try {
                val prettyPrintJson = GsonBuilder().setPrettyPrinting()
                    .create().toJson(JsonParser.parseString(message))
                Timber.d(" \n$prettyPrintJson")
            } catch (m: JsonSyntaxException) {
                Timber.d(message)
            }
        } else {
            Timber.d(message)
            return
        }
    }
}