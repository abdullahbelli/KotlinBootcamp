package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    val f = Fonksiyonlar()

    //void - unit
    f.selamla1()

    //return
    val gelenSonuc = f.selamla2()
    println("Gelen Sonuç : $gelenSonuc")

    //parametre
    f.selamla3("Abdullah")

    f.topla(3,4)

    f.topla(5,6,"Mehmet")

    println("JVM default encoding: " + System.getProperty("file.encoding"))
}