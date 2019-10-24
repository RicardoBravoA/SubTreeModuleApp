package com.example.lenovo.apprutatours.Adaptadores

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.ruta.tours.entity.LugarTuristico
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.model.LatLngBounds
import com.ruta.tours.R
import java.util.concurrent.TimeUnit

/*
class AdapterPlaceTourist: RecyclerView.Adapter<AdapterPlaceTourist.Companion.Holder>,Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var list: MutableList<LugarTuristico>
    lateinit var rv: View
    var listFiltered: MutableList<LugarTuristico>


    private var mResultList = arrayListOf<Int>()
    private lateinit var mGoogleApiClient: GoogleApiClient
    private lateinit var mBounds: LatLngBounds
    private lateinit var  mPlaceFilter: AutocompleteFilter

    lateinit var mContext: Context
    internal var layout: Int = 0



    constructor(list: MutableList<LugarTuristico>, mContext: Context) : super() {
        this.list = list
        this.listFiltered = list
        this.mContext = mContext
    }

    //Contiene la información a visualizar.
    companion object {
        class Holder: RecyclerView.ViewHolder{
            lateinit var  txtNamePlaceTourist: TextView

            constructor(rv: View?): super(rv){
                txtNamePlaceTourist = rv!!.findViewById<TextView>(R.id.txtNamePlaceTourist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        var holder: Holder
        rv = LayoutInflater.from(parent!!.context).inflate(R.layout.item_place_tourist, parent, false)
        holder = Holder(rv)
        return holder

    }

    override fun getItemCount(): Int {
        return listFiltered.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        var lt: LugarTuristico
        lt = listFiltered.get(position)
        holder!!.txtNamePlaceTourist.setText(lt.getName())
        rv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(mContext, holder.txtNamePlaceTourist.text.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var charString: String = constraint.toString()
                if(charString.isEmpty()){
                    listFiltered = list
                }else{
                    var filteredList: MutableList<LugarTuristico> = mutableListOf()
                    for (lt: LugarTuristico in list){
                        if (lt.getName()!!.toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(lt)
                        }
                    }
                    listFiltered = filteredList
                }
                var filterResults: FilterResults = FilterResults()
                filterResults.values = listFiltered
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listFiltered = results!!.values as MutableList<LugarTuristico>
                notifyDataSetChanged()
            }

        }
    }

    /*
    override fun getFilter(): Filter {
        val filter = object  : Filter(){
            override fun performFiltering(p0: CharSequence): FilterResults {
                val results = Filter.FilterResults()
                if(p0 != null ){
                    mResultList = getAutocomplete(p0)
                }
                if(mResultList != null){
                    results.values = mResultList
                    results.count = mResultList!!.size
                }
                return results
            }

            override fun publishResults(p0: CharSequence, p1: FilterResults?) {
                if(p1 != null && p1.count > 0){
                    notifyDataSetChanged()
                }else{

                }
            }

        }
        return filter
    }
    * */

    private  fun getAutocomplete(p0: CharSequence): ArrayList<Int> {

        if (mGoogleApiClient.isConnected) {
            Log.i("", "Starting autocomplete query for: " + p0!!)

            val results = Places.GeoDataApi.getAutocompletePredictions(mGoogleApiClient, p0.toString(),
            mBounds, mPlaceFilter)

            val autocompletePredictions = results.await(60, TimeUnit.SECONDS)

            val status = autocompletePredictions.status
            if (!status.isSuccess) {
                Toast.makeText(mContext, "Error contacting API: " + status.toString(),
                        Toast.LENGTH_SHORT).show()
                Log.e("", "Error getting autocomplete prediction API call: " + status.toString())
                autocompletePredictions.release()
            }

            Log.i("", "Query completed. Received " + autocompletePredictions.count
                    + " predictions.")

            val iterator = autocompletePredictions.iterator()
            val resultList = ArrayList<Any>(autocompletePredictions.count)
            while (iterator.hasNext()) {
                val prediction = iterator.next()
                // Get the details of this prediction and copy it into a new PlaceAutocomplete object.
                //resultList.add(LugarTuristico(prediction.hashCode(),prediction.placeId.toString()))

            }
            autocompletePredictions.release()

             return mResultList
        }
        Log.e("", "Google API client is not connected for autocomplete query.")
        //return null

        return mResultList
    }


    inner class PredictionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val mPrediction: TextView
        public val mRow: RelativeLayout

        init {
            mPrediction = itemView.findViewById<View>(R.id.txtNamePlaceTourist) as TextView
            mRow = itemView.findViewById<View>(R.id.predictedRow) as RelativeLayout
        }
    }



}
*/
