package com.example.recyclerview2.thirdRV

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.databinding.ActivityThirdBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class ThirdActivity : AppCompatActivity() {

    private var modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
    lateinit var pahlawanAdapters: PahlawanAdapters

    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity)
        }

        getListPahlawan()
        // setUpRecycler()
    }

   /* fun setUpRecycler() {
        binding.rvListPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
        }
    }*/

    fun getListPahlawan() {
          // Membuka asset json
            /*val stream = assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()*/
        val strContent = getJSONObject()
            try {
                val jsonObject = JSONObject(strContent)
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
                for (i in 0 until jsonArray.length()){
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.image = jsonObjectData.getString("img")
                    modelPahlawan.add(dataApi)
                }
                pahlawanAdapters = PahlawanAdapters(modelPahlawan)
                // setUp Recycler View
                binding.rvListPahlawan.adapter = pahlawanAdapters
            }catch (e : JSONException){
                e.printStackTrace()
            }
    }

    fun getJSONObject(): String?{
        val str: String
        try {
            str = assets.open("pahlawan_nasional.json").bufferedReader().use { it.readText() }
            /*val stream = assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            str = String(buffer, StandardCharsets.UTF_8)*/
        }catch (e : IOException){
            Toast.makeText(this, "Oppsss, Coba lagi", Toast.LENGTH_SHORT).show()
            return null
        }
        return str
    }
}