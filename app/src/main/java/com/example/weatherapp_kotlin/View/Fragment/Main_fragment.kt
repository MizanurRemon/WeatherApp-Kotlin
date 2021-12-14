package com.example.weatherapp_kotlin.View.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp_kotlin.Adapter.City_weather_adapter
import com.example.weatherapp_kotlin.Model.Retrofit_client
import com.example.weatherapp_kotlin.Model.Weather_API
import com.example.weatherapp_kotlin.Model.Weather_response
import com.example.weatherapp_kotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main_fragment : Fragment() {


    val lat = "23.68"
    val lon = "90.35"
    val cnt = "50"
    val appid = "e384f9ac095b2109c751d95296f8ea76"
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        val weatherView = view.findViewById(R.id.weatherViewID) as RecyclerView

        //val api_service = Retrofit_client.buildService(Weather_API::class.java)
        //val call = api_service.getCurrentWeatherData(lat, lon, cnt, appid)

        val request = Retrofit_client.buildService(Weather_API::class.java)
        val call = request.getCurrentWeatherData(lat, lon, cnt, appid)

        call.enqueue(object : Callback<Weather_response> {
            override fun onResponse(
                call: Call<Weather_response>,
                response: Response<Weather_response>
            ) {
                if (response.isSuccessful) {
                    //progress_bar.visibility = View.GONE
                    weatherView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = City_weather_adapter(response.body()!!.list)

                        //Log.d("errrorxxx", response.body()!!.list.get(0).name);
                    }
                }
            }

            override fun onFailure(call: Call<Weather_response>, t: Throwable) {
                //Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("errrorxxx", "${t.message}");
            }
        })

        return view;
    }


}


