package com.poc.cleanarchitect.ui.news.domain

import com.poc.cleanarchitect.ui.news.domain.model.NewsResponse
import io.reactivex.Observable

interface NewsUseCase {
    fun getNews(apiKey : String) : Observable<NewsResponse>
    /*fun getNewsDB() : MutableList<TbNews>
    fun getArticle(userId : Long) : TbNews*/

//    fun saveGithubDB(githubUser: TbNews) : Long
//    fun saveImgNews(imgNews: TbImageNews) : Long
}