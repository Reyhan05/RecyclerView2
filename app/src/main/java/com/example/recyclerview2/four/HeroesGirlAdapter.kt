package com.example.recyclerview2.four

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerview2.data.HeroesGirlsResponse
import com.example.recyclerview2.databinding.ItemPahlawanWanitaBinding

class HeroesGirlAdapter : RecyclerView.Adapter<HeroesGirlAdapter.MyViewHolder>() {

    private var listData = ArrayList<HeroesGirlsResponse>()

    fun setDatas(newList: List<HeroesGirlsResponse>) {
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
    }

    class MyViewHolder(val binding: ItemPahlawanWanitaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            ItemPahlawanWanitaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listData[position]
        holder.binding.apply {
            itemNameGirls.text = data.name
            Glide.with(itemImgGirls.context)
                .load(data.imageUrl)
                .apply(RequestOptions())
                .override(500, 500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemImgGirls)
        }
    }

    override fun getItemCount() = listData.size
}