package com.example.bitirmeprojesi.data.repo

import com.example.bitirmeprojesi.data.datasource.YemeklerDataSource
import com.example.bitirmeprojesi.data.entity.CRUDCevap
import com.example.bitirmeprojesi.data.entity.SepetYemekler
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.entity.YemeklerCevap
import javax.inject.Inject

class YemeklerRepository @Inject constructor(private val yemeklerDataSource: YemeklerDataSource) {

    suspend fun yemekleriYukle() : List<Yemekler>{
       return yemeklerDataSource.yemekleriYukle()
    }

    suspend fun sepeteYemekEkle(
        yemekAdi: String,
        yemekResimAdi: String,
        yemekFiyat: Int,
        yemekAdet: Int,
        kullaniciAdi: String)
     {
         yemeklerDataSource.sepeteYemekEkle(
            yemekAdi,
            yemekResimAdi,
            yemekFiyat,
            yemekAdet,
            kullaniciAdi
        )
    }

    suspend fun sepettekiYemekleriGetir(kullaniciAdi: String): List<SepetYemekler> {
        return yemeklerDataSource.sepettekiYemekleriGetir(kullaniciAdi)
    }

    suspend fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String) {
       yemeklerDataSource.sepettenYemekSil(sepetYemekId, kullaniciAdi)
    }



}
