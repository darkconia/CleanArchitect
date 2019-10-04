package com.poc.cleanarchitect.ui.news.datasource

import com.poc.cleanarchitect.ui.news.datasource.remote.NewsNetworkDataSource
import com.poc.cleanarchitect.ui.news.datasource.remote.NewsNetworkRepository
import org.koin.dsl.module

val newsDataModule = module {

//    factory<NewsLocalDataSource> { NewsLocalRepository(get(),get()) }
    factory<NewsNetworkDataSource> { NewsNetworkRepository(get()) }
}