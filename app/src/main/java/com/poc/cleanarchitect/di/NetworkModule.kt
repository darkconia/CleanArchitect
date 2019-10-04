package com.poc.cleanarchitect.di

import com.poc.cleanarchitect.BuildConfig
import com.poc.cleanarchitect.ui.news.datasource.remote.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module{
    single{ provideOkhttpClient() }

//    single { provideRetrofit<LoginAPI>(get(),"https://api.github.com/")}
    single { provideRetrofit<NewsApi>(get(),"https://newsapi.org/v2/")}
//    single { provideRetrofit<NewsAPI>(get(),NEWS_URL)}
}

fun provideOkhttpClient(): OkHttpClient {

    val logger = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    return OkHttpClient.Builder()
        .addInterceptor(logger)
        .followRedirects(true)
        .followSslRedirects(true)
        .retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .cache(null)
        .build()
}

inline fun <reified T> provideRetrofit(client: OkHttpClient,baseURL : String): T {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(T::class.java)
}
