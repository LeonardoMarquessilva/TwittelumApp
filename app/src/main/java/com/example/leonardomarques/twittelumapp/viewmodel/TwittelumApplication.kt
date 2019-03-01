package com.example.leonardomarques.twittelumapp.viewmodel

import android.app.Application

class TwittelumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instace = this
    }

    companion object {
        private lateinit var instace: TwittelumApplication

        fun getInstance() = instace
    }

}