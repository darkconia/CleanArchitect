package com.poc.cleanarchitect.ui.news.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.poc.cleanarchitect.R
import com.poc.cleanarchitect.databinding.ActivityNewsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class NewsActivity : AppCompatActivity() , NewsContract.View {

    private val newsViewModel: NewsViewModel by viewModel()
    val presenter : NewsContract.Presenter by inject { parametersOf(this,newsViewModel) }
    var binding : ActivityNewsBinding? = null

    override fun onSuccess() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityNewsBinding>(this,R.layout.activity_news).apply {
            viewmodel = newsViewModel
        }




    }
}
