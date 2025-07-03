package com.example.kotlinbootcampday.degiskenler

fun main() {
    // println("Merhaba Dunya!!")

    var id = 1
    var ad = "Mont"
    var resim = "mont.png"
    var puan = 4.7
    var fiyat = 4500
    var stokDurumu = true

    println("Id: $id")
    println("Ad: $ad")
    println("Resim: $resim")
    println("Puan: $puan")
    println("Fiyat: $fiyat")
    println("Stok Durumu: $stokDurumu")

    //Sabitler - Constant
    var sayi = 30 // deüer değişebilir
    sayi = 100
    println(sayi)

    val numara = 50 // numara sğrekli 50 olacak değer değiştirilemez
    // performansa fayda var çünkü esnek bir yapı daha çok güç harcar
    println(numara)

    //Tür Dönüşümü - Type Casting

    //1- Sayısaldan Sayısala Dönüşüm (Tehlikeli)
    val  d = 89.56
    val i = 34
    val sonuc1 = d.toUInt()
    println(sonuc1)
    val sonuc2 = i.toDouble()
    println(sonuc2)

    //2- Sayısaldan Metine Dönüşüm
    var x = 85
    val sonuc3 = x.toString() //"85"
    println(sonuc3)

    //3- Metinden Sayısala Dönüşüm
    val yazi = "48T" // 48T inteeger yapılamaz bu yüzden null değer vermesini sağladık
    var sonuc4 = yazi.toIntOrNull()

    if (sonuc4 != null){
        println(sonuc4)

    }else{
        println("Sonuc nulldur")
    }

}