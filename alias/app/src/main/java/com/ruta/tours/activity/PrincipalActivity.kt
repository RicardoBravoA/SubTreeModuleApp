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
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.app_bar_principal.*
import kotlinx.android.synthetic.main.content_principal.*

class PrincipalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        llLocation.setOnClickListener {
            startActivity(Intent(this, MapsActivity:: class.java))
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_Inicio -> {
                startActivity(Intent(this, PrincipalActivity:: class.java))
            }
            R.id.nav_ubicacion -> {
                startActivity(Intent(this, MapsActivity:: class.java))
            }
            R.id.nav_buscar -> {
                startActivity(Intent(this, SearchActivity:: class.java))
            }
            R.id.nav_tours -> {
                startActivity(Intent(this, ToursActivity:: class.java))
            }
            R.id.nav_favoritos -> {
                startActivity(Intent(this, FavoritesActivity:: class.java))
            }
            R.id.nav_configuracion -> {
                startActivity(Intent(this, SettingsActivity:: class.java))
            }
            R.id.nav_opiniones -> {

            }
            R.id.nav_ayuda -> {
                startActivity(Intent(this, HelpActivity:: class.java))
            }
            R.id.nav_cerrar_sesion -> {
                finish()
                logout()
            }
            R.id.nav_politicas_privacidad -> {
                startActivity(Intent(this, PrivacyPoliciesActivity:: class.java))
            }
            R.id.nav_terminos_condiciones -> {
                startActivity(Intent(this, TermsConditionsActivity:: class.java))
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun logout(){
        val intent = Intent(this, LoginActivity:: class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
