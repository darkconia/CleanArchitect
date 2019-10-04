package com.poc.cleanarchitect.ui.news.datasource.remote

import com.poc.cleanarchitect.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

interface NewsNetworkDataSource {
    fun getNewsList(apiKey : String) : Observable<NewsResponse>
    fun getGithubList(apiKey : String) : Observable<NewsResponse>
}