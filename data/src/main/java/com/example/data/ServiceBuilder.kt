package com.tsviatoslav.data

import com.example.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private var client = OkHttpClient.Builder().addInterceptor { chain ->
        val original: Request = chain.request()

        val requestBuilder: Request.Builder = original.newBuilder()
            .header("Content-Type", "application/json")
            .method(original.method(), original.body())

        val request: Request = requestBuilder.build()
        chain.proceed(request)
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}