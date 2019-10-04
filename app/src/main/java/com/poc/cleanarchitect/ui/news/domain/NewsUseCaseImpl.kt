package com.poc.cleanarchitect.ui.news.domain

import com.poc.cleanarchitect.ui.news.datasource.remote.NewsNetworkDataSource
import com.poc.cleanarchitect.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

class NewsUseCaseImpl(private val remoteSource: NewsNetworkDataSource) : NewsUseCase{
    override fun getNews(apiKey: String): Observable<NewsResponse> {
       return remoteSource.getNewsList(apiKey)
    }
}