package com.example.leonardomarques.twittelumapp.modelo

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Insert
import android.arch.persistence.room.PrimaryKey

@Entity

data class Tweet (val mensagem: String,
                  val foto : String?,
                  @PrimaryKey(autoGenerate = true) val id: Int = 0) {


    override fun toString(): String {
        return mensagem
    }


}