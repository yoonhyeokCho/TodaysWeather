package com.example.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.data.Weather
import com.example.todaysweather.feature.R
import com.example.todaysweather.feature.databinding.ItemWeatherBinding

class HomeRecyclerViewAdapter(
    var items: Array<Weather>
) : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(inflater, parent, false)
        return HomeRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HomeRecyclerViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            item: Weather
        ) {
            with(binding){
                itemWeatherImage.setImageResource(setSkyImage(item.precipitationType, item.sky))
                weatherInfo = item
            }
        }

        fun setSkyImage(precipitationType: String, sky: String): Int {
            return when (precipitationType) {
                "0" -> {
                    when (sky) {
                        "1" -> com.example.todaysweather.shared.R.drawable.sun
                        else -> com.example.todaysweather.shared.R.drawable.cloud
                    }
                }
                "1" -> com.example.todaysweather.shared.R.drawable.rain
                "2" -> com.example.todaysweather.shared.R.drawable.rain
                "3" -> com.example.todaysweather.shared.R.drawable.snow
                "7" -> com.example.todaysweather.shared.R.drawable.snow
                else -> com.example.todaysweather.shared.R.drawable.rain
            }

        }

    }

}
