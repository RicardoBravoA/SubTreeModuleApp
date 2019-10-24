package com.ruta.tours.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruta.tours.entity.LugarTuristico
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.material.navigation.NavigationView
import com.ruta.tours.R
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.app_bar_search.*

class SearchActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        PlaceSelectionListener{

    lateinit var recyclerView: RecyclerView
    var list: MutableList<LugarTuristico> = mutableListOf()
    lateinit var layoutManager: RecyclerView.LayoutManager
    var sname: Array<String> = arrayOf("Pimentel1", "Pimentel2", "Pimentel3", "Pimenel4", "Santa Rosa")
    //lateinit var adapter: AdapterPlaceTourist
    lateinit var searchView: SearchView

    /*Para la busqueda autocompletada : Metodos de PLACESELECTIONLISTENER*/
    override fun onPlaceSelected(p0: Place?) {
        Toast.makeText(applicationContext,""+p0!!.name+ p0!!.phoneNumber, Toast.LENGTH_LONG).show()
    }

    override fun onError(p0: Status?) {
        Toast.makeText(applicationContext,"No se encontraron resultados"+p0.toString(), Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)


        //Para lo del menú navegación
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)


        //Para lo del RecyclerView
        val recyclerView:RecyclerView= findViewById(R.id.rv_place_tourist)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        var count: Int = 0
        for (name: String in sname){
            val c =  object: LugarTuristico(sname[count]){}
            list.add(c)
            count++

        }
        //adapter = AdapterPlaceTourist(list, this    )
        //recyclerView.adapter = adapter

        //Autocompletado de la búsqueda...
        /*
        val autocompleteFragment = fragmentManager.findFragmentById(R.id.autocomplete_fragment) as PlaceAutocompleteFragment
        autocompleteFragment.setOnPlaceSelectedListener(this)
        */
        //La busqueda con searchView

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.principal, menu)
        var item: MenuItem = menu!!.findItem(R.id.action_search)
        searchView = MenuItemCompat.getActionView(item) as SearchView
        MenuItemCompat.setOnActionExpandListener(item, object : MenuItemCompat.OnActionExpandListener{
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                toolbar.setBackgroundColor(Color.WHITE)
                (searchView.findViewById<EditText>(R.id.search_src_text)).setHintTextColor(Color.BLACK)
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
                searchView.setQuery("", false)
                return true
            }
        })
        searchView.maxWidth = Int.MAX_VALUE
        searchName(searchView)
        return true
    }

    private fun searchName(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                //adapter.filter.filter(newText)
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }

        if (item!!.itemId == R.id.action_search){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
        if (!searchView.isIconified){
            searchView.isIconified = true
            return
        }
        super.onBackPressed()
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
