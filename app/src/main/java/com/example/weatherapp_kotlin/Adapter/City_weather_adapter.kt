package com.example.weatherapp_kotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp_kotlin.Model.Weather_response
import com.example.weatherapp_kotlin.R

class City_weather_adapter(val cities: List<Weather_response.Main>) :
    RecyclerView.Adapter<City_weather_adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): City_weather_adapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.city_weather_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: City_weather_adapter.ViewHolder, position: Int) {
        holder.bindItems(cities[position])
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(cityData: Weather_response.Main) {
             val cityNameText:TextView = itemView.findViewById(R.id.cityNameTextID)
             val conditionText:TextView = itemView.findViewById(R.id.conditionTextID)
             val temperatureTextID:TextView = itemView.findViewById(R.id.temperatureTextID)
            cityNameText.text = cityData.name
            //conditionText.text = cityData.address
        }
    }
}

/*class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityNameText:TextView = itemView.findViewById(R.id.cityNameTextID)
    private val conditionText:TextView = itemView.findViewById(R.id.conditionTextID)
    private val temperatureTextID:TextView = itemView.findViewById(R.id.temperatureTextID)
    //private val rating:TextView = itemView.findViewById(R.id.movie_rating)

    fun bind(movie: Result) {
        Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
        title.text = "Title: "+movie.title
        overview.text = movie.overview
        rating.text = "Rating : "+movie.vote_average.toString()
    }

}*/

