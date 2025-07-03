package com.example.kotlinbootcampday.standart_programlama

fun main() {
    // 1,2,3

    for (i in 1..3){// Swwift dilinde 1...3 olur
        //i = index (Dizilerdeki indeks numarası)
        println("Dongu 1 : $i")

    }

    // 10 ile 20 arasında çalışsın 5er artsın
    for(x in 10..20 step 5 ){
        println("Dongu 2 : $x")
    }

    // 20 ile 10 arasında çalışsın 5er azalsın
    for(x in 20 downTo 10 step 5 ){
        println("Dongu 3 : $x")
    }

    // 1,2,3

    var sayac = 1

    while (sayac < 4 ){
        println("Dongu 4 : $sayac")
        sayac++
    }

    //1,2,3,4,5
    for (i in 1..5){
        if (i == 3){
            break// Donguyu durdurur
        }
        println("Dongu 5 : $i")

    }

    for (i in 1..5){
        if (i == 3){
            continue// Bulunduğu adımı pas geçer
        }
        println("Dongu 6 : $i")

    }

}