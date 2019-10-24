package com.ruta.tours.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView
import com.ruta.tours.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.app_bar_search.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var lastlocation: Location

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onMarkerClick(p0: Marker?)= false

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.setOnMarkerClickListener(this)
        map.uiSettings.isZoomControlsEnabled= true

        setUpMap()
    }

    private fun placeMarker(location: LatLng){
        val markerOptions = MarkerOptions().position(location)
        map.addMarker(markerOptions.snippet("Aquí estoy"))
    }

    private fun setUpMap(){
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        map.isMyLocationEnabled = true

        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) {location ->
            if (location != null){
                lastlocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarker(currentLatLng)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 13f))
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_Inicio -> {
                val intent = Intent(this, PrincipalActivity:: class.java)
                startActivity(intent)

            }
            R.id.nav_ubicacion -> {
                val intent = Intent(this, MapsActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_buscar -> {
                val intent = Intent(this, SearchActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_tours -> {
                val intent = Intent(this, ToursActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_favoritos -> {
                val intent = Intent(this, FavoritesActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_configuracion -> {
                val intent = Intent(this, SettingsActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_opiniones -> {

            }
            R.id.nav_ayuda -> {
                val intent = Intent(this, HelpActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_cerrar_sesion -> {
                finish()
                logout()
            }
            R.id.nav_politicas_privacidad -> {
                val intent = Intent(this, PrivacyPoliciesActivity:: class.java)
                startActivity(intent)
            }
            R.id.nav_terminos_condiciones -> {
                val intent = Intent(this, TermsConditionsActivity:: class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    //Cerrar sesión
    fun  logout(){
        val intent = Intent(this, LoginActivity:: class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
