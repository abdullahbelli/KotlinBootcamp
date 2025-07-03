package com.example.kotlinbootcampday.collecitons

fun main() {
    val f1=Filmler(1,"Babam ve Oğlum",50)
    val f2=Filmler(2,"Neşeli Hayatlar",30)
    val f3=Filmler(3,"Kış Uykusu",80)

    val filmlerListesi = ArrayList<Filmler>()
    filmlerListesi.add(f1)
    filmlerListesi.add(f2)
    filmlerListesi.add(f3)

    for(film in filmlerListesi){
        println("---------------------")
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }

    //Sıralama - Sorting
    println("\n---- Fiyata Göre Artan ----")
    //Ascend -ASC
    val siralama1 = filmlerListesi.sortedWith(compareBy{ it.fiyat})     //it : sırayla gelen film f1,f2,f3
    for (film in siralama1){                                            //listenin içerisindeki eleman bilgisi
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }

    println("\n---- Fiyata Göre Azalan ----")
    //DESC
    val siralama2 = filmlerListesi.sortedWith(compareByDescending{ it.fiyat})
    for (film in siralama2){
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }

    println("\n---- Ada Göre Artan ----")
    //Ascend -ASC
    val siralama3 = filmlerListesi.sortedWith(compareBy{ it.ad})
    for (film in siralama3){
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }


    //Filtreleme
    println("\n----- Filtreleme 1-------")
    val filtreleme1 = filmlerListesi.filter { it.fiyat > 40 && it.fiyat <60 }
    for (film in filtreleme1){
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }

    println("\n----- Filtreleme 2-------")
    val filtreleme2 = filmlerListesi.filter { it.ad.contains("at") }
    for (film in filtreleme2){
        println("${film.id} : ${film.ad} ${film.fiyat} ₺")
    }
}