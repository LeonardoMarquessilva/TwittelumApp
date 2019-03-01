package com.example.leonardomarques.twittelumapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.leonardomarques.twittelumapp.repository.TweetRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    private fun repository() = TweetRepository(Injetor.tweetDao())

    @Suppress ("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T= TweetViewModel(repository()) as T
}