package com.curso.cartaodevisitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {
    @Query("SELECT * FROM DATABASECARD")
    fun getAll(): LiveData<List<DatabaseCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(databaseCard: DatabaseCard)

}