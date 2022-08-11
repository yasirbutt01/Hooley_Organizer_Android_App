package com.hooleyapp.organizer.data.plaidremote

import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.utilities.Constants
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientPlaid {
    private val baseUrl = Constants.PLAID_BASE_URL
    var retrofit: Retrofit? = null
    val dispatcher = Dispatcher()

    fun getClient(): Retrofit? {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .client(OkHttpClient().newBuilder().dispatcher(dispatcher)
                            .addInterceptor(Interceptor { chain: Interceptor.Chain? ->
                        val newRequest = chain?.request()!!.newBuilder()
                                newRequest.addHeader("Content-Type", "application/json")
                        return@Interceptor chain.proceed(newRequest.build())
                    }
                    ).addInterceptor(logging)
                            .build())
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
        return retrofit
    }



}