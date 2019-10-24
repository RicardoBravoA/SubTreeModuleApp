package com.ruta.tours.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.ruta.tours.R
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.app_bar_favorites.*

class FavoritesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
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
        menuInflater.inflate(R.menu.principal, menu)
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
}
