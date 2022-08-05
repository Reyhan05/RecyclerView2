package com.example.recyclerview2.thirdRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview2.cake.BatterItem
import com.example.recyclerview2.cake.CakeModel
import com.example.recyclerview2.databinding.ItemCakeBinding
import com.example.recyclerview2.databinding.ItemPahlawanBinding

class CakeAdapter(val listCake: ArrayList<BatterItem>) :
    RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {
    class CakeViewHolder(val itemCake: ItemCakeBinding) :
        RecyclerView.ViewHolder(itemCake.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CakeViewHolder(
        ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.itemCake.apply {
            with(listCake[position]) {
                idKue.text = id
                tvTipeKue.text = type
            }
        }
    }

    override fun getItemCount() = listCake.size
}