package com.example.leonardomarques.twittelumapp.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.leonardomarques.twittelumapp.modelo.Tweet
import com.example.leonardomarques.twittelumapp.repository.TweetRepository

class TweetViewModel (private val repository: TweetRepository): ViewModel() {
    fun lista() = repository.lista()

    fun salva(tweet: Tweet) = repository.salva(tweet)

    fun deleta(tweet: Tweet) = repository.deleta(tweet)
}