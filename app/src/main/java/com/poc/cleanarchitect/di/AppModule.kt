package com.poc.cleanarchitect.di

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
    single { CompositeDisposable() }
}