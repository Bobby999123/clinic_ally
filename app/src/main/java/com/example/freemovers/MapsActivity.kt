package com.example.freemovers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.shape.MarkerEdgeTreatment
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        requestAccessFineLocation()
        super.onStart()

        when{

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestAccessFineLocation(){
        this.requestPermissions(
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                999



        )

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val safdarjung = LatLng(28.5680,77.2058)
        mMap.addMarker(MarkerOptions().position(safdarjung).title("Marker in Safdarjung Hospital "+" Bed Available:34 "+"Room Available:22"+"Open:24x7"))
//        mMap.setOnMarkerClickListener {
//            startActivity(Intent(this, MapsActivity::class.java))
////            onBackPressed()}
//        }

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(safdarjung))

        val aiims=LatLng(28.5659,77.2111)
        mMap.addMarker(MarkerOptions().position(aiims).title("Marker On AIIMS" +
                "Bed Available:57 "+"Room Available:30"+"Open:24x7"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(aiims))

    }
}