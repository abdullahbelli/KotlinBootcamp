package com.example.kotlinbootcampday.nesne_tabanli_programlama

fun main() {
    val o = Odev_2()

    val sonuc = o.fahrenhietDonusturme(10)
    println("Girilen derecenin Fahrenheit karşılığı: $sonuc")


    val sonuc2 = o.dikdortgenCevre(10,30)
    println("Dikdörtgenin Çevresi : $sonuc2")

    val sonuc3 = o.faktoriyelHesaplama(5)
    println("Faktöriyel : $sonuc3")

    val sonuc4=o.aHarfiniSay("Abdullah")
    println("Kelimedeki A sayısı : $sonuc4")

    val sonuc5=o.icAciHesaplama(4)
    println("İç açılar toplamı : $sonuc5 °")

    val sonuc6=o.maasHesabi(21)
    println("Maaşınız : $sonuc6 ₺")

    val sonuc7=o.internetUcreti(51)
    println("İnternet Ücretiniz : $sonuc7 ₺")

}