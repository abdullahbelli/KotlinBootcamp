package com.example.bitirmeprojesi.retrofit

import com.example.bitirmeprojesi.data.entity.CRUDCevap
import com.example.bitirmeprojesi.data.entity.SepetYemeklerCevap
import com.example.bitirmeprojesi.data.entity.YemeklerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

//yemekler/tumYemekleriGetir.php
//yemekler/sepeteYemekEkle.php
//yemekler/sepettekiYemekleriGetir.php
//yemekler/sepettenYemekSil.php
//resimler/ayran.png

interface YemeklerDao {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle() : YemeklerCevap

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepeteYemekEkle(@Field("yemek_adi") yemekAdi: String,
                                @Field("yemek_resim_adi") yemekResimAdi: String,
                                @Field("yemek_fiyat") yemekFiyat: Int,
                                @Field("yemek_siparis_adet") yemekAdet: Int,
                                @Field("kullanici_adi") kullaniciAdi: String): CRUDCevap

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepettekiYemekleriGetir(
        @Field("kullanici_adi") kullaniciAdi: String
    ): SepetYemeklerCevap


    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sepettenYemekSil(
        @Field("sepet_yemek_id") sepetYemekId: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CRUDCevap



}