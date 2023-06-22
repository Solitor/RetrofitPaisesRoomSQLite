package com.example.retrofitpaisesroomsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var paisRepository: PaisRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paisDao = AppDatabase.getDatabase(application).paisDao()
        paisRepository = PaisRepository(paisDao)

        fetchDataAndSaveToDatabase()
        retrieveDataFromDatabase()
    }

    private fun fetchDataAndSaveToDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            paisRepository.fetchDataAndSaveToDatabase()
        }
    }

    private fun retrieveDataFromDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            val paises = paisRepository.getAllPaises()
            // Handle the retrieved data as needed
            for (pais in paises) {
                println(pais.nome)
            }
        }
    }

}