package com.example.googlemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment
import com.google.android.gms.maps.model.LatLng

class StreetViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_street_view)

        val streetViewPanoramaFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_streetView) as SupportStreetViewPanoramaFragment?

        streetViewPanoramaFragment?.getStreetViewPanoramaAsync { streetViewPanorama->
        streetViewPanorama.setPosition(LatLng(40.690493, -74.046259))

        }
    }
}