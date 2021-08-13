package com.curso.cartaodevisitas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.cartaodevisitas.App
import com.curso.cartaodevisitas.adapter.CardAdapter
import com.curso.cartaodevisitas.databinding.ActivityMainBinding
import com.curso.cartaodevisitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { CardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllCard()
        insertListener()
    }


    private fun insertListener(){
        binding.fabAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddCartaodeVisita::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun getAllCard() {
        mainViewModel.getAll().observe(this) { databaseCard ->
            adapter.submitList(databaseCard)
        }
    }
}