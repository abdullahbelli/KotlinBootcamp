package com.example.bitirmeprojesi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.data.entity.SepetYemekler
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.EOFException
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var repository: YemeklerRepository): ViewModel() {
    var sepetYemekler = MutableLiveData<List<SepetYemekler>>()

    var sepetYemeklerTutar= MutableLiveData<Int>()
    init {
        sepetYemeklerTutar.value=0
        sepettekiYemekleriYukle()
    }

    fun sepettekiYemekleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {

                val liste = repository.sepettekiYemekleriGetir("AbdullahBelli")
                sepetYemekler.value = liste
                sepetYemeklerTutar.value = liste.sumOf { it.yemek_fiyat * it.yemek_siparis_adet }


            }
            catch (e: Exception){
                sepetYemekler.value=emptyList()
                sepetYemeklerTutar.value=0
                Log.e("Sepet Yemekler","Kullanıcı adı bulunamadı.")
            }

        }
    }

    fun sepettenYemekSil(yemekler: SepetYemekler){
        CoroutineScope(Dispatchers.Main).launch {
                repository.sepettenYemekSil(yemekler.sepet_yemek_id,"AbdullahBelli")
                sepettekiYemekleriYukle()



        }
    }

    fun sepetAdetAzalt(yemekler: SepetYemekler){
        CoroutineScope(Dispatchers.Main).launch {
                if (yemekler.yemek_siparis_adet>1){
                    repository.sepettenYemekSil(yemekler.sepet_yemek_id,"AbdullahBelli")
                    repository.sepeteYemekEkle(yemekler.yemek_adi,yemekler.yemek_resim_adi,yemekler.yemek_fiyat,yemekler.yemek_siparis_adet-1,"AbdullahBelli")
                }
                else{
                    repository.sepettenYemekSil(yemekler.sepet_yemek_id,"AbdullahBelli")
                }
                sepettekiYemekleriYukle()



        }
    }

    fun sepetAdetArttir(kullaniciAdi: String,yemekler: SepetYemekler){

        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetYemekler.value = repository.sepettekiYemekleriGetir(kullaniciAdi)
                var sepetYemek = sepetYemekler.value.find { it.yemek_adi == yemekler.yemek_adi }
                if (sepetYemek != null) {
                    repository.sepettenYemekSil(sepetYemek.sepet_yemek_id, kullaniciAdi)

                    repository.sepeteYemekEkle(
                        sepetYemek.yemek_adi,
                        sepetYemek.yemek_resim_adi,
                        sepetYemek.yemek_fiyat,
                        sepetYemek.yemek_siparis_adet + 1,
                        kullaniciAdi
                    )
                } else {
                    repository.sepeteYemekEkle(
                        yemekler.yemek_adi,
                        yemekler.yemek_resim_adi,
                        yemekler.yemek_fiyat,
                        1,
                        kullaniciAdi
                    )
                }

            } catch (e: EOFException) {
                repository.sepeteYemekEkle(
                    yemekler.yemek_adi,
                    yemekler.yemek_resim_adi,
                    yemekler.yemek_fiyat,
                    1,
                    kullaniciAdi
                )

            }
            sepettekiYemekleriYukle()
        }
    }
}

