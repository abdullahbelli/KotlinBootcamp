package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    //Nullable,Null Safety, Optional(Swift)
    //Genellikle mobil uygulama geliştirme dillerinde yer almaktadır.
    //null , NaN ,nil
    //1.Tanımlama
    var mesaj:String? = null

      mesaj = "Merhaba"

    //Yöntem 1
    //Sorun yoksa çalışır,sorun varsa uuygulama çökmez
    println("Yöntem 1 : ${mesaj?.uppercase()}")

    val x = mesaj?.uppercase()
    // x.lowercase()

    //Yöntem 2
    //Sorun yoksa çalışır,sorun varsa uygulama çöker
    //Çok emin olduğunu kodlarda kullanabilirsiniz
   //  println("Yöntem 2 : ${mesaj!!.uppercase()}")

    //Yöntem 3
    //null Kontrolü
   if(mesaj != null){
       println("Yöntem 3 : ${mesaj.uppercase()}")
   }else{
       println("Değişkende null yer almaktadır.")
   }

   //null kontrolü
    mesaj?.let {
        //yukarıdakinin sadece if kısmı
        println("Yöntem 3 : ${mesaj.uppercase()}")
    }
}