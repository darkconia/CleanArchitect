package com.poc.cleanarchitect.ui.news

import com.poc.cleanarchitect.ui.news.datasource.newsDataModule
import org.koin.dsl.module

var newsContribute = newsModule +
        newsDataModule
