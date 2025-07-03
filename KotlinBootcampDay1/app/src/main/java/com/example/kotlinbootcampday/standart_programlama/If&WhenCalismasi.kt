package com.example.kotlinbootcampday.standart_programlama

fun main() {
    val yas = 17

    if (yas >= 18){ //true
        println("Resitsiniz")
    }
    else{ //false
        println("Resit degilsiniz")
    }

    val ka = "admin"
    val sifre = 123456
    val sayi = 10

    if (ka == "admin" && sifre == 123456){
        println("Hosgeldiniz")

    }else{
        println("Hatali Giris")
    }

    if (sayi == 9 || sayi == 10){
        println("Sayi 9 veya 10 dur")
    }else{
        println("9 veya 10 değildir")
    }

    //when , diğer dillerde switch olarak bilinir

    val number = 6

    when(number){
        1 -> println("Sayi 1 dir")
        2 -> println("Sayi 2 dir")
        else -> println("Tanimlanmayan sayi")
    }

    
}