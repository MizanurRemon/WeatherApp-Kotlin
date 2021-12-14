package com.example.weatherapp_kotlin.Model

data class Weather_response(
    val cod: String,
    val count: Double,
    val list: List<Main>,
    val message: String
) {
    data class Main(
        val clouds: Clouds,
        val coord: Coord,
        val dt: Double,
        val id: Double,
        val main: Main,
        val name: String,
        val rain: Any,
        val snow: Any,
        val sys: Sys,
        val weather: List<Weather>,
        val wind: Wind
    ) {
        data class Clouds(
            val all: Double
        )

        data class Coord(
            val lat: Double,
            val lon: Double
        )

        data class Main(
            val feels_like: Double,
            val grnd_level: Double,
            val humidity: Double,
            val pressure: Double,
            val sea_level: Double,
            val temp: Double,
            val temp_max: Double,
            val temp_min: Double
        )

        data class Sys(
            val country: String
        )

        data class Weather(
            val description: String,
            val icon: String,
            val id: Double,
            val main: String
        )

        data class Wind(
            val deg: Double,
            val speed: Double
        )
    }
}