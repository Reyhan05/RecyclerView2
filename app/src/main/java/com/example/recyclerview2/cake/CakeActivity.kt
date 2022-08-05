package com.example.recyclerview2.cake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.databinding.ActivityCakeBinding
import com.example.recyclerview2.thirdRV.CakeAdapter
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class CakeActivity : AppCompatActivity() {

     private var cakeModel = ArrayList<BatterItem>()
    // lateinit var cakeAdapter: CakeAdapter

    private var _binding : ActivityCakeBinding? = null
    private val binding get() = _binding as ActivityCakeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCakeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCake.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CakeActivity)
        }

        // setUp Adapter
        val cakeAdapter = CakeAdapter(cakeModel)
        binding.rvCake.adapter = cakeAdapter


        getListCake()

    }

    private fun getListCake() {
        val json = getJSONObject()
        try {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()){
                val jsonObjectData = jsonArray.getJSONObject(i)
                val getBatters = jsonObjectData.getJSONObject("batters")
                val getBatter = getBatters.getJSONArray("batter")
                for (u in 0 until getBatter.length()){
                    val batterItem = getBatter.getJSONObject(u)
                    val dataJson = BatterItem(
                        id = batterItem.getString("id"),
                        type = batterItem.getString("type")
                    )
                    cakeModel.add(dataJson)
                }
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
    }

    private fun getJSONObject(): String? {
        val str: String
        try {
            str = assets.open("cake.json").bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            Toast.makeText(this, "Oppsss, Coba lagi", Toast.LENGTH_SHORT).show()
            return null
        }
        return str
    }
}

