package com.example.leonardomarques.twittelumapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.*
import android.widget.AdapterView.*
import com.example.leonardomarques.twittelumapp.adapter.TweetAdapter
import com.example.leonardomarques.twittelumapp.bancodedados.TwittelumDatabase
import com.example.leonardomarques.twittelumapp.modelo.Tweet
import com.example.leonardomarques.twittelumapp.viewmodel.TweetViewModel
import com.example.leonardomarques.twittelumapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    private lateinit var viewModel: TweetViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        viewModel= ViewModelProviders.of(this,ViewModelFactory).get(TweetViewModel::class.java)

        viewModel.lista().observe(this,observer())


        fab_add.setOnClickListener {

            val intencao = Intent(this, TwettActivity::class.java)
            startActivity(intencao)


            val listener = OnItemClickListener{adapter, item, posicao,id ->
                val tweet = lista_tweet.getItemAtPosition(posicao) as Tweet

                perguntaSePrecisaDeletarEsse(tweet)
            }
            lista_tweet.onItemClickListener = listener
        }



    }

    private fun perguntaSePrecisaDeletarEsse(tweet: Tweet) {
        val dailog = AlertDialog.Builder(this)

        dailog.setMessage("Deseja mesmo apagar esse tweet?")
        dailog.setTitle("Atencao")
        dailog.setPositiveButton("Sim") {_: DialogInterface, _: Int -> viewModel.deleta(tweet)}
        dailog.setNegativeButton("Nao", null)

        dailog.show()

    }

    private fun observer():Observer<List<Tweet>>{
    return Observer {
        lista_tweet.adapter = TweetAdapter(it!!)
    }
}



}