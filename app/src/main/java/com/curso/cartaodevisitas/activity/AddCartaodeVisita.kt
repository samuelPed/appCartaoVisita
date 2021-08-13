package com.curso.cartaodevisitas.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.curso.cartaodevisitas.App
import com.curso.cartaodevisitas.R
import com.curso.cartaodevisitas.data.DatabaseCard
import com.curso.cartaodevisitas.databinding.ActivityAddCartaodeVisitaBinding


class AddCartaodeVisita : AppCompatActivity() {

    private val binding by lazy { ActivityAddCartaodeVisitaBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.btnCancelar.setOnClickListener{
           finish()
        }

        binding.btnConfirmar.setOnClickListener{
            val databaseCard = DatabaseCard(
                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(databaseCard)
            Toast.makeText(this, R.string.labelSucesso, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}