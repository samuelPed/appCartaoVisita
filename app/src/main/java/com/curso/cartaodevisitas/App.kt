package com.curso.cartaodevisitas

import android.app.Application
import com.curso.cartaodevisitas.data.AppDatabase
import com.curso.cartaodevisitas.data.CardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CardRepository(database.dao()) }
}