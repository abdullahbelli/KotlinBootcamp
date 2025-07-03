package com.example.kotlinbootcampday.nesne_tabanli_programlama

data class Yemekler (var id:Int,var ad:String,var fiyat:Int){ // burada tür belirtmek gerekli
    //Constructor - init mmetodu
    //Bu sınıftan nesne oluştuğunda çalışsın.
    init {
        println("****** Nesne Olustu ******")
    }


    fun bilgiAl(){
        println("-------------------")
        println("Id     : ${id}")
        println("Ad     : ${ad}")
        println("Fiyat  : ${fiyat}")
    }
    //this : Bulunduğu sınıfı temsil eder.Swift dilinde self olarak kullanılır.
    //super : Kalıtım ile bir üst sınıfı temsil eder.
}