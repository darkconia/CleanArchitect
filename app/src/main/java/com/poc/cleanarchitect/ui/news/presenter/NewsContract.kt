package com.poc.cleanarchitect.ui.news.presenter

import androidx.lifecycle.LifecycleObserver

interface NewsContract {

    interface View : NewsContract{
        fun onSuccess()
    }

    interface Presenter : LifecycleObserver {
        fun getNews()
    }
}