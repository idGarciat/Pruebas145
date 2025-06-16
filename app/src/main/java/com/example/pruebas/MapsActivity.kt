package com.example.pruebas

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.pruebas.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices


import android.os.Looper



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)




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
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        val sucre = LatLng(-19.0333, -65.2627)
        mMap.addMarker(MarkerOptions().position(sucre).title("Marcador en Sucre"))

        val santacruz = LatLng(-17.7833, -63.1825)
        mMap.addMarker(MarkerOptions().position(santacruz).title("Marcador en Santa Cruz"))

        val beni = LatLng(-14.8333, -64.9000)
        mMap.addMarker(MarkerOptions().position(beni).title("Marcador en Beni"))

        val cochabamba = LatLng(-17.3833, -66.1667)
        mMap.addMarker(MarkerOptions().position(cochabamba).title("Marcador en Cochabamba"))

        val laPaz = LatLng(-16.5000, -68.1193)
        mMap.addMarker(MarkerOptions().position(laPaz).title("Marcador en La Paz"))

        val oruro = LatLng(-17.9667, -67.1167)
        mMap.addMarker(MarkerOptions().position(oruro).title("Marcador en Oruro"))

        val potosi = LatLng(-19.5833, -65.7500)
        mMap.addMarker(MarkerOptions().position(potosi).title("Marcador en Potosí"))

        val tarija = LatLng(-21.5333, -64.7333)
        mMap.addMarker(MarkerOptions().position(tarija).title("Marcador en Tarija"))

        val pando = LatLng(-10.5000, -66.0000)
        mMap.addMarker(MarkerOptions().position(pando).title("Marcador en Pando"))

        val casita = LatLng(-17.7833, -63.1825)
        mMap.addMarker(MarkerOptions().position(casita).title("Marcador en mi casita"))


        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucre))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15f))
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isMyLocationButtonEnabled = true

        mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE

        //mMap.isMyLocationEnabled = true


        checkLocationPermission() // Verifica y solicita permisos de ubicación
        enableUserLocation() // Habilita la ubicación del usuario en el mapa



    }
    private fun enableUserLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        }
    }

    private val LOCATION_PERMISSION_REQUEST = 1

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST
            )
        } else {
            enableUserLocation()
        }
    }



}