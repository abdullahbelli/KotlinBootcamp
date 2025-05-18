package com.example.odev7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev7.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao { //Dao : Database Access Object
    @Query("SELECT * FROM yapilacaklar")
    suspend fun yapilacaklariYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacak: Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacak: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM Yapilacaklar WHERE yapilacak_ad LIKE '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar>
}