package com.example.kotlinbootcampday.collecitons

fun main() {
    //HashMap JSON veri modeline benzemektedir.
    //Map,Dictionary(Swift)
    //Shared Prferences,DataStore,UUserDefault(Swift) benziyor

    val iller = HashMap<Int,String>()

    iller.put(16,"BURSA")
    iller[34] = "İSTANBUL"
    iller[6] = "ANKARA"
    println(iller)

    iller[16] = "YENİ BURSA"
    println(iller)

    val il = iller[6]
    println(il)

    println("Boyut : ${iller.size}")

    for ((key,deger) in iller){
        println("$key -> $deger")
    }

    iller.remove(34)
    println(iller)

    iller.clear()
    println(iller)
}