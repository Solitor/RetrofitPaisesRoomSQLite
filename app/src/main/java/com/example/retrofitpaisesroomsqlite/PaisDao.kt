package com.example.retrofitpaisesroomsqlite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PaisDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaises(paises: List<PaisEntity>)

    @Query("SELECT * FROM pais_table")
    suspend fun getAllPaises(): List<PaisEntity>
}