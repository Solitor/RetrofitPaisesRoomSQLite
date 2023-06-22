package com.example.retrofitpaisesroomsqlite

class PaisRepository(private val paisDao: PaisDao) {
    suspend fun fetchDataAndSaveToDatabase() {
        // 1. Fetch data from API using Retrofit
        val response = RetrofitClient.apiService.getPaises()

        if (response.isSuccessful) {
            val paises = response.body()

            if (paises != null) {
                // 2. Save PaisEntity objects to Room database
                paisDao.insertPaises(paises)
            }
        }
    }

    suspend fun getAllPaises(): List<PaisEntity> {
        return paisDao.getAllPaises()
    }
}