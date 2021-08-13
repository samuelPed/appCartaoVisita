package com.curso.cartaodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

class CardRepository (private val dao: CardDao){

    fun insert(databaseCard: DatabaseCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(databaseCard)
        }
    }

    fun getAll() = dao.getAll()
}