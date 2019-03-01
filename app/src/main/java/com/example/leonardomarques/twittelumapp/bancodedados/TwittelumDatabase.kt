package com.example.leonardomarques.twittelumapp.bancodedados

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context
import com.example.leonardomarques.twittelumapp.modelo.Tweet
import com.example.leonardomarques.twittelumapp.modelo.TweetDAO
import java.security.AccessControlContext

@Database(entities = [Tweet :: class] , version = 2)


abstract class TwittelumDatabase : RoomDatabase(){

    abstract fun tweetDao(): TweetDAO

    companion object {
        private var database: TwittelumDatabase? = null

        private val DATABASE = " TwittelumDB"

        fun getInstance(context: Context): TwittelumDatabase {

            return database ?: criaBanco(context).also { database = it}
        }

        private fun criaBanco (context: Context): TwittelumDatabase {
            return Room.databaseBuilder(context, TwittelumDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .addMigrations(Migration1Para2)
                .build()
        }


    }

}

object Migration1Para2 : Migration(1,2) {

    override fun migrate(database: SupportSQLiteDatabase){

        val sql ="alter table Tweet add column foto text"
        database.execSQL(sql)
    }

}
