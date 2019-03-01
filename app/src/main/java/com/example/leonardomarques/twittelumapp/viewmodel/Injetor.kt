package com.example.leonardomarques.twittelumapp.viewmodel

import com.example.leonardomarques.twittelumapp.bancodedados.TwittelumDatabase

object Injetor {

    private val contexto = TwittelumApplication.getInstance()

    private val database = TwittelumDatabase.getInstance(contexto)

    fun tweetDao() = database.tweetDao()
}