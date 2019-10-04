package com.poc.cleanarchitect.ui.news

import com.poc.cleanarchitect.ui.news.domain.NewsUseCase
import com.poc.cleanarchitect.ui.news.domain.NewsUseCaseImpl
import com.poc.cleanarchitect.ui.news.presenter.NewsContract
import com.poc.cleanarchitect.ui.news.presenter.NewsPresenter
import com.poc.cleanarchitect.ui.news.presenter.NewsViewModel
import org.koin.dsl.module

val newsModule = module {

    single  { NewsViewModel() }
    factory  <NewsContract.Presenter> { (view: NewsContract.View,viewModel : NewsViewModel) -> NewsPresenter(view, get(),viewModel,get()) }
    factory  <NewsUseCase> { NewsUseCaseImpl(get()) }
}