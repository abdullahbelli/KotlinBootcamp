package com.example.kotlinbootcampday.nesne_tabanli_programlama.kalitim

class Kedi : Memeli() {
    override fun sesCikar() {
        //super.sesCikar() -> super : Kalıtım ile üst sınıfı (Memeli) temsil eder
        println("Miyav Miyav")
    }
}