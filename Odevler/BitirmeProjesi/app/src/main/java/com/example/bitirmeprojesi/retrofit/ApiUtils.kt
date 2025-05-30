package com.example.bitirmeprojesi.retrofit

class ApiUtils {
    companion object {

        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getYemeklerDAO() : YemeklerDao {
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)
        }
    }
}