package com.example.leonardomarques.twittelumapp.repository

import com.example.leonardomarques.twittelumapp.modelo.Tweet
import com.example.leonardomarques.twittelumapp.modelo.TweetDAO

class TweetRepository (private val fonteDeDados:TweetDAO) {

    fun lista() = fonteDeDados.lista()

    fun salva(tweet: Tweet)= fonteDeDados.salva(tweet)

    fun deleta(tweet: Tweet)= fonteDeDados.deleta(tweet)
}