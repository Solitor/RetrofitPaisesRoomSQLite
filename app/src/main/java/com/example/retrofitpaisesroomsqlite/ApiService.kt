package com.example.retrofitpaisesroomsqlite


import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET() // Replace with your API endpoint
    suspend fun getPaises(): Response<List<Pais>> // Adjust the response type as per your API response
}