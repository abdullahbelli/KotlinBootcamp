package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    ucretHesapla(KonserveBoyut.ORTA,55)
}

fun ucretHesapla(boyut: KonserveBoyut,adet:Int){
    when(boyut){
        KonserveBoyut.KUCUK -> println("Ucretimiz : ${adet * 104} ₺")
        KonserveBoyut.ORTA -> println("Ucretimiz : ${adet * 204} ₺")
        KonserveBoyut.BUYUK -> println("Ucretimiz : ${adet * 304} ₺")
    }
}