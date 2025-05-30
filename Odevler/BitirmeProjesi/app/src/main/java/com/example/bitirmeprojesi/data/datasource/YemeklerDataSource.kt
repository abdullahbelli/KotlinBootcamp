package com.example.bitirmeprojesi.data.datasource

import android.util.Log
import com.example.bitirmeprojesi.data.entity.SepetYemekler
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class YemeklerDataSource (var yemeklerDao: YemeklerDao) {
    suspend fun yemekleriYukle() : List<Yemekler> = withContext(Dispatchers.IO){
        return@withContext yemeklerDao.yemekleriYukle().yemekler
    }

    suspend fun sepeteYemekEkle(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat: Int,yemek_siparis_adet: Int,kullanici_adi: String){
        val crudCevap=yemeklerDao.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        Log.e("Sepet Yemek","Success:${crudCevap.success} - Message:${crudCevap.message}")
    }

    suspend fun sepettekiYemekleriGetir(kullaniciAdi: String): List<SepetYemekler> = withContext(Dispatchers.IO) {
        return@withContext yemeklerDao.sepettekiYemekleriGetir(kullaniciAdi).sepet_yemekler
    }

    suspend fun sepettenYemekSil(sepet_yemek_id: Int,kullanici_adi: String) {
        val crudCevap = yemeklerDao.sepettenYemekSil(sepet_yemek_id, kullanici_adi)
        Log.e("Sepet Yemek", "Success:${crudCevap.success} - Message:${crudCevap.message}")
    }



}

