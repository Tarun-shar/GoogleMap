package com.example.googlemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        Change map type
        val mapOptionButton:ImageButton = findViewById(R.id.mapOptionMenu)

        val popUpMenu = PopupMenu(this,mapOptionButton)
        popUpMenu.menuInflater.inflate(R.menu.map_options, popUpMenu.menu)
        popUpMenu.setOnMenuItemClickListener { menuItem ->
            changeMap(menuItem.itemId)
            true
        }

        mapOptionButton.setOnClickListener {
            popUpMenu.show()
        }

//        Add clickListener on floating point button
        val fbStreetView = findViewById<FloatingActionButton>(R.id.fbStreetView)
        fbStreetView.setOnClickListener {
            val intent = Intent(this , StreetViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun changeMap(itemId: Int) {
        when(itemId){
            R.id.normal_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.hybrid_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.satellite_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.terrain_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }
}























