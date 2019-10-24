package com.ruta.tours.entity

abstract class LugarTuristico{

    private var sname: String = ""

    constructor(sname: String) {
        this.setName(sname)
    }

    fun getName(): String {
        return sname
    }

    fun setName(sname: String) {
        this.sname = sname
    }
}

    //(var id_lt: Int, var name_lt:String, var descripcion_lt:String, var imagen_lt: Int)
/*
    private var name: String? = null
    private var category: String? = null
    private var rating: String? = null
    private var opennow: String? = null
    private var vicinity: String? = null
    private var latitude: Double = 0.toDouble()
    private var longitude:Double = 0.toDouble()

    fun MyGooglePlaces(){
        this.name = ""
        this.category = ""
        this.rating = ""
        this.opennow = ""
        this.vicinity = ""
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String) {
        this.category = category
    }

    fun getRating(): String? {
        return rating
    }

    fun setRating(rating: String) {
        this.rating = rating
    }

    fun getOpen(): String? {
        return opennow
    }

    fun setOpenNow(open: String) {
        this.opennow = open
    }

    fun getVicinity(): String? {
        return vicinity
    }

    fun setVicinity(vicinity: String) {
        this.vicinity = vicinity
    }

    fun setLatLng(lat: Double, lon: Double) {
        this.latitude = lat
        this.longitude = lon
    }

    /*
    protected var id_lt: Int = 0
    protected lateinit var name_lt: String
    private lateinit var descripcion_lt: String
    private var imagen_lt: Int = 0



    constructor(name_lt: String) {
        this.setNombre(name_lt)
        this.setDescripcion(descripcion_lt)
    }

    fun getNombre(): String{
        return  name_lt
    }

    fun setNombre(nombre: String){
        this.name_lt = name_lt
    }

    fun getDescripcion(): String{
        return  descripcion_lt
    }

    fun setDescripcion(descripcion_lt: String){
        this.descripcion_lt = descripcion_lt
    }

}*/