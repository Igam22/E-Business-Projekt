package com.hka.bloodrecommendationapp.Model

class ProductList {

    var ID:Int = 0
    lateinit var name:String
    lateinit var cat:String
    lateinit var her:String
    lateinit var war:String
    lateinit var pos1:String
    var vege:Boolean=false
    var veg:Boolean=false
    var prot:Boolean=false
    var fet:Boolean=false
    var kal:Boolean=false
    var pr:Double=0.0
}

val productList: List<ProductList> = listOf(
    ProductList().apply {
        ID = 1
        name = "Produkt 1"
        cat = "Kategorie 1"
        her = "Herkunft 1"
        war = "Warnhinweis 1"
        pos1 = "Position 1"
        vege = true
        veg = false
        prot = true
        fet = false
        kal = true
        pr = 10.0
    },
    ProductList().apply {
        ID = 2
        name = "Produkt 2"
        cat = "Kategorie 2"
        her = "Herkunft 2"
        war = "Warnhinweis 2"
        pos1 = "Position 2"
        vege = true
        veg = true
        prot = false
        fet = true
        kal = false
        pr = 20.0
    },
    ProductList().apply {
        ID = 3
        name = "Produkt 3"
        cat = "Kategorie 1"
        her = "Herkunft 1"
        war = "Warnhinweis 1"
        pos1 = "Position 3"
        vege = false
        veg = true
        prot = true
        fet = true
        kal = false
        pr = 30.0
    },
    ProductList().apply {
        ID = 4
        name = "Produkt 4"
        cat = "Kategorie 2"
        her = "Herkunft 2"
        war = "Warnhinweis 2"
        pos1 = "Position 4"
        vege = true
        veg = false
        prot = false
        fet = false
        kal = true
        pr = 40.0
    },
    ProductList().apply {
        ID = 5
        name = "Produkt 5"
        cat = "Kategorie 3"
        her = "Herkunft 3"
        war = "Warnhinweis 3"
        pos1 = "Position 5"
        vege = false
        veg = false
        prot = true})
