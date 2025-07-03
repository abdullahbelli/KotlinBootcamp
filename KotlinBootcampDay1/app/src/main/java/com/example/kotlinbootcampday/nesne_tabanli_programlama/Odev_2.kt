package com.example.kotlinbootcampday.nesne_tabanli_programlama

class Odev_2 {
    fun fahrenhietDonusturme(derece:Int) : Double {
        val fahrenhiet = ((derece * 1.8) + 32)
        println("---- Fahrenheit Dönüştürldü ----")
        return fahrenhiet
    }

    fun dikdortgenCevre(kısaKenar:Int , uzunKenar:Int):Int {
        val cevre = 2*(kısaKenar + uzunKenar)
        println("\n---- Çevre Hesaplandı ----")
        return cevre
    }


    fun faktoriyelHesaplama(sayi:Int): Int {
        var faktoriyel=1
        for (i in 1..sayi){
             faktoriyel *=i
        }
        println("\n---- Faktöriyel Hesaplandı ----")
        return faktoriyel
    }

    fun aHarfiniSay(kelime: String): Int {
        var sayac = 0
        for (harf in kelime) { // for (harf in kelime) ifadesi Kotlin dilinde String içindeki karakterlerde dolaşmak için doğrudan kullanılabilen bir yapıdır ve tamamen doğrudur.
            if (harf == 'a' || harf == 'A') {
                sayac++
            }
        }
        println("\n---- 'a' Harfi Sayıldı ----")
        println("Kelime: $kelime")

        return sayac
    }

    fun icAciHesaplama(kenarSayisi:Int):Int{
        val icAciToplami = (kenarSayisi - 2)*180
        println("\n---- İç Açılar Toplamı Hesaplandı ----")
        return icAciToplami

    }

   fun maasHesabi(gunSayisi:Int):Double{
       val saat =gunSayisi*8
       val maas = if(saat>160){
           (saat-160)*20 + (160*10)
       }else{
           saat*10
       }
       println("\n---- Maaşınız Hesaplandı ----")
        return maas.toDouble()
    }

    fun internetUcreti(kotaMiktari:Int): Double {
        val ucret = if (kotaMiktari <= 50) {
            100.0
        } else {
            ((kotaMiktari - 50) * 4) + 100.0
        }
        println("\n---- İnternet Ücreti Hesaplandı ----")
        println("\nKullanılan Kota : $kotaMiktari GB ")
        return ucret
    }

}