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


class ForeCastListAdapter(
    val mContext: Context,
    val items: List<Forcast>,
    val itemClick: (String) -> Unit
) : RecyclerView.Adapter<ForeCastListAdapter.ViewHolder>() {

    inner class ViewHolder(var view: View, itemClick: (String) -> Unit) :
        RecyclerView.ViewHolder(view) {

        private var tvdata: TextView = view.findViewById(R.id.tvdate)
        private var tvtempature: TextView = view.findViewById(R.id.tvtempature)
        private var tvdeatil: TextView = view.findViewById(R.id.tvdeatil)
        private var imageView: ImageView = view.findViewById(R.id.imageView)

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

        var itemView = LayoutInflater.from(mContext).inflate(R.layout.forecast_item, null)

        return ViewHolder(itemView,itemClick)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecastView(items[position])

    }
}