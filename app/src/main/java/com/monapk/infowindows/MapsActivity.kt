package com.monapk.infowindows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        with(mMap) {
            val fuji = LatLng(35.3606, 138.7274)
            addMarker(MarkerOptions().position(fuji).title("富士山").snippet("富士山は日本で一番高い山です."))
            moveCamera(CameraUpdateFactory.newLatLngZoom(fuji, 9.0f))
            // Note: カスタム情報ウィンドウの設定
            setInfoWindowAdapter(CustomInfoWindowAdapter(this@MapsActivity))
        }
    }
}