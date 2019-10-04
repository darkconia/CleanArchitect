package com.poc.cleanarchitect.ui.news.datasource.remote

import com.poc.cleanarchitect.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

class NewsNetworkRepository(private val api: NewsApi) : NewsNetworkDataSource {
    override fun getNewsList(apiKey: String): Observable<NewsResponse> {
        return api.getNews(apiKey = apiKey)
    }

    override fun getGithubList(apiKey: String): Observable<NewsResponse> {
        return api.getNews(apiKey = apiKey)
    }
}