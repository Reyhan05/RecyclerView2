package com.example.recyclerview2.data

import com.google.gson.annotations.SerializedName


data class HeroesGirlsResponse(

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

)
