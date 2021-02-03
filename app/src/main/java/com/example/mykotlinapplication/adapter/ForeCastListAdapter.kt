package com.example.mykotlinapplication.adapter

import android.content.Context
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.bean.Forcast
import com.example.mykotlinapplication.databinding.ForecastItemBinding


class ForeCastListAdapter(
    val mContext: Context,
    val items: List<Forcast>,
    val itemClick: (String) -> Unit
) : RecyclerView.Adapter<ForeCastListAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ForecastItemBinding, itemClick: (String) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        private var tvdata: TextView = binding.tvdate
        private var tvtempature: TextView = binding.tvtempature
        private var tvdeatil: TextView = binding.tvdeatil
        private var imageView: ImageView = binding.imageView

        //绑定view
        fun bindForecastView(forcast: Forcast) {
            with(forcast) {
                tvdata.text = date.toString()
                tvtempature.text = temperature.toString()
                tvdeatil.text = detail
                Glide.with(mContext).load(url).into(imageView)
            }
            tvdata.setOnClickListener {
                itemClick(forcast.date.toString())
            }
            tvtempature.setOnClickListener {
                itemClick(forcast.temperature.toString())
            }
            tvdeatil.setOnClickListener {
                itemClick(forcast.detail)
            }
            imageView.setOnClickListener{
                itemClick("大美女头像")
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       // var itemView = LayoutInflater.from(mContext).inflate(R.layout.forecast_item, null)

        return ViewHolder(binding,itemClick)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecastView(items[position])

    }
}