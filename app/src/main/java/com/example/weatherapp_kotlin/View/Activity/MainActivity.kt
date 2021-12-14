package com.example.weatherapp_kotlin.View.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp_kotlin.R
import com.example.weatherapp_kotlin.View.Fragment.Main_fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_container, Main_fragment())
                .commit()
        }
    }
}