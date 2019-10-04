package com.poc.cleanarchitect.ui.news.presenter

import android.util.Log
import com.poc.cleanarchitect.Config
import com.poc.cleanarchitect.di.RxPresenter
import com.poc.cleanarchitect.ui.news.domain.NewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NewsPresenter (
    val view: NewsContract.View,
    val usecase: NewsUseCase,
    val viewModel: NewsViewModel,
    compositeDisposable: CompositeDisposable
) : NewsContract.Presenter, RxPresenter(compositeDisposable) {

    override fun getNews() {
        Log.d("getNews","...")
        usecase.getNews(Config.apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    Log.d("Onnext","...")
                },
                onError = {
                    it.printStackTrace()
                },
                onComplete = {
                    Log.d("onComplete","...")
                }
            )
            .addTo(compositeDisposable)
    }

}