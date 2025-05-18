package com.example.odev7.data.repo

import com.example.odev7.data.datasource.YapilacaklarDataSource
import com.example.odev7.data.entity.Yapilacaklar

class YapilacaklarRepository (var yapilacaklarDataSource: YapilacaklarDataSource ) {

    suspend fun kaydet(yapilacak_ad: String) {
        yapilacaklarDataSource.kaydet(yapilacak_ad)
    }

    suspend fun guncelle(yapilacak_id:Int,yapilacak_ad: String)
            = yapilacaklarDataSource.guncelle(yapilacak_id,yapilacak_ad)

    suspend fun sil(yapilacak_id:Int) = yapilacaklarDataSource.sil(yapilacak_id)

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> {

        return yapilacaklarDataSource.yapilacaklariYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = yapilacaklarDataSource.ara(aramaKelimesi)
}