package com.poc.cleanarchitect.ui.news.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel(){

    var test = MutableLiveData<String>()

    init {
        test.value = "NON TAJAI"
    }
}