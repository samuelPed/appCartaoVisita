package com.curso.cartaodevisitas.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.curso.cartaodevisitas.data.CardRepository
import com.curso.cartaodevisitas.data.DatabaseCard
import java.lang.IllegalArgumentException

class MainViewModel(private val cardRepository: CardRepository): ViewModel(){

    fun insert(card: DatabaseCard){
        cardRepository.insert(card)
    }

    fun getAll(): LiveData<List<DatabaseCard>>{
        return cardRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: CardRepository):
        ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}