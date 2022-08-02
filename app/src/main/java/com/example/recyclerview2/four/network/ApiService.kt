package com.example.recyclerview2.four.network

import com.example.recyclerview2.data.HeroesGirlsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("heroes_girl")
    fun nameHeroesGirls(
    ): Call<List<HeroesGirlsResponse>>

}