package com.example.recyclerview2.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.data.HeroesGirlsResponse
import com.example.recyclerview2.databinding.ActivityFourBinding
import com.example.recyclerview2.four.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourActivity: AppCompatActivity() {

    private lateinit var binding : ActivityFourBinding
    var heroesGirls = MutableLiveData<List<HeroesGirlsResponse>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameHeroesGirls()
        heroesGirls.observe(this){
            setUpRecyclerview(it)
        }
    }

    private fun setUpRecyclerview(it: List<HeroesGirlsResponse>) {
        binding.rvPahlawanWanita.apply {
            val mAdapter = HeroesGirlAdapter()
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
            mAdapter.setDatas(it)
        }
    }


    fun nameHeroesGirls(
    ) {
        ApiConfig.getApiService().nameHeroesGirls()
            .enqueue(object: Callback<List<HeroesGirlsResponse>> {
                override fun onResponse(
                    call: Call<List<HeroesGirlsResponse>>,
                    response: Response<List<HeroesGirlsResponse>>
                ) {
                    if (response.isSuccessful) heroesGirls.value = response.body()
                }
                override fun onFailure(call: Call<List<HeroesGirlsResponse>>, t: Throwable) {
                }
        })
    }


}