package com.example.odev7.data.datasource

import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var yapilacaklarDao: YapilacaklarDao) {
    suspend fun kaydet(yapilacak_ad: String){
        val yeniYapilacak = Yapilacaklar(0,yapilacak_ad)
        yapilacaklarDao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacak_id:Int,yapilacak_ad: String){
        val guncellenenYapilacak = Yapilacaklar(yapilacak_id,yapilacak_ad)
        yapilacaklarDao.guncelle(guncellenenYapilacak)
    }

    suspend fun sil(yapilacak_id:Int){
        val silinenYapilacak = Yapilacaklar(yapilacak_id,"")
        yapilacaklarDao.sil(silinenYapilacak)
    }

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> = withContext(Dispatchers.IO) {
        return@withContext  yapilacaklarDao.yapilacaklariYukle()

    }

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = withContext(Dispatchers.IO) {
        return@withContext yapilacaklarDao.ara(aramaKelimesi)
    }
}