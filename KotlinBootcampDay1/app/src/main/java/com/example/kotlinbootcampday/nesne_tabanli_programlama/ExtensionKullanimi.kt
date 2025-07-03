package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    val sonuc = /* infix sayesinde */ 5 carp 2 //şeklinde yazabildik //5.carp(2) //5 this oldu
    println(sonuc)
}

infix fun Int.carp(sayi:Int) : Int{ //Int sınıfına carp fonksiyonu ekledik

    return this * sayi //this(Int)
}