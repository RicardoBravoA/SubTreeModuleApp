package com.ruta.tours.util

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient

class PlacesAutoCompleteActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    override fun onConnected(p0: Bundle?) {
        Log.v("Google API Callback", "Connection Done")
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
/*
    protected var mGoogleApiClient: GoogleApiClient? = null

    private var mAutocompleteView: EditText? = null
    private var mRecyclerView: RecyclerView? = null
    private var mLinearLayoutManager: LinearLayoutManager? = null
    private var mAutoCompleteAdapter: ListaPlaceTouristAdapter? = null
    internal var delete: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildGoogleApiClient()
        setContentView(R.layout.activity_search)
        mAutocompleteView = findViewById(R.id.autocomplete_places) as EditText

        delete = findViewById(R.id.cross) as ImageView

        mAutoCompleteAdapter = ListaPlaceTouristAdapter(this, R.layout.searchview_adapter,
                mGoogleApiClient, BOUNDS_INDIA, null)

        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mLinearLayoutManager = LinearLayoutManager(this)
        mRecyclerView!!.layoutManager = mLinearLayoutManager
        mRecyclerView!!.adapter = mAutoCompleteAdapter
        delete.setOnClickListener(this)
        mAutocompleteView!!.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int,
                                       count: Int) {
                if (s.toString() != "" && mGoogleApiClient.isConnected) {
                    mAutoCompleteAdapter!!.getFilter().filter(s.toString())
                } else if (!mGoogleApiClient.isConnected) {
                    Toast.makeText(applicationContext, Constants.API_NOT_CONNECTED, Toast.LENGTH_SHORT).show()
                    Log.e(Constants.PlacesTag, Constants.API_NOT_CONNECTED)
                }

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,
                                           after: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        mRecyclerView!!.addOnItemTouchListener(
                RecyclerItemClickListener(this, object : RecyclerItemClickListener.OnItemClickListener() {
                    fun onItemClick(view: View, position: Int) {
                        val item = mAutoCompleteAdapter!!.getItem(position)
                        val placeId = String.valueOf(item.placeId)
                        Log.i("TAG", "Autocomplete item selected: " + item.description)
                        /*
                             Issue a request to the Places Geo Data API to retrieve a Place object with additional details about the place.
                         */

                        val placeResult = Places.GeoDataApi
                                .getPlaceById(mGoogleApiClient, placeId)
                        placeResult.setResultCallback { places ->
                            if (places.count == 1) {
                                //Do the things here on Click.....
                                Toast.makeText(applicationContext, places.get(0).latLng.toString(), Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(applicationContext, Constants.SOMETHING_WENT_WRONG, Toast.LENGTH_SHORT).show()
                            }
                        }
                        Log.i("TAG", "Clicked: " + item.description)
                        Log.i("TAG", "Called getPlaceById to get Place details for " + item.placeId)
                    }
                })
        )
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    @Synchronized
    protected fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.GEO_DATA_API)
                .build()
    }

    override fun onConnected(bundle: Bundle?) {
        Log.v("Google API Callback", "Connection Done")
    }

    override fun onConnectionSuspended(i: Int) {
        Log.v("Google API Callback", "Connection Suspended")
        Log.v("Code", i.toString())
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.v("Google API Callback", "Connection Failed")
        Log.v("Error Code", connectionResult.errorCode.toString())
        Toast.makeText(this, Constants.API_NOT_CONNECTED, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        if (v === delete) {
            mAutocompleteView!!.setText("")
        }
    }

    public override fun onResume() {
        super.onResume()
        if (!mGoogleApiClient!!.isConnected && !mGoogleApiClient!!.isConnecting) {
            Log.v("Google API", "Connecting")
            mGoogleApiClient.connect()
        }
    }

    public override fun onPause() {
        super.onPause()
        if (mGoogleApiClient.isConnected) {
            Log.v("Google API", "Dis-Connecting")
            mGoogleApiClient.disconnect()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {

        private val BOUNDS_INDIA = LatLngBounds(
                LatLng(-0.0, 0.0), LatLng(0.0, 0.0))
    }
*/

}
