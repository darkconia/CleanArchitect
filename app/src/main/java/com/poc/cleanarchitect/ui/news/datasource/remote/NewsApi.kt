package com.poc.cleanarchitect.ui.news.datasource.remote

import com.poc.cleanarchitect.ui.news.domain.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface NewsApi {

    @GET("top-headlines")
    fun getNews(@Query("sources") sources : String = "techcrunch",
                @Query("apiKey") apiKey : String
    ): Observable<NewsResponse>
}