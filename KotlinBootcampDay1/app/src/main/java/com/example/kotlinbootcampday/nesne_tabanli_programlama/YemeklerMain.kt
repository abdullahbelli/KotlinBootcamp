package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    //Nesne olusturma
    val y1 = Yemekler(100,"Kofte",249)
    //Değer Okuma
    y1.bilgiAl()

    //Değer atamak/değiştirmek
    y1.fiyat = 350
    y1.bilgiAl()

    val y2 = Yemekler(200,"Baklava",300)

    y2.bilgiAl()
    y2.ad = "Soguk Baklava"
    y2.bilgiAl()


}