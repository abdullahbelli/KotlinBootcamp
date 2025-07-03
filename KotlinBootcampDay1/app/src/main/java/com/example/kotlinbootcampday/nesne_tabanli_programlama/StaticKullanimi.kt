package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    val a =ClassA()

 /*   //Standart nesne tabanlı erişim
    println(a.x)//Burada tek bir nesne var
    a.metod()//Bu daha iyi performans açısından


    //Sanal nesne - Virtual Object -Nameless Object
    println(ClassA().x)//1.Nesne
    ClassA().metod()//2.nesne
*/

    //Static Kullanımı
    println(ClassA.x)
    ClassA.metod()
}