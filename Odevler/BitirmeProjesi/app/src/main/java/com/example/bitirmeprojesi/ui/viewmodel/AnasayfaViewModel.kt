package com.example.bitirmeprojesi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class AnasayfaViewModel @Inject constructor(
    private val yemeklerRepository: YemeklerRepository
) : ViewModel() {

    val yemeklerListesi = MutableLiveData<List<Yemekler>>()
    val sepetYemekler = MutableLiveData<List<SepetYemekler>>()

    init {
        yemekleriYukle()
    }

    fun yemekleriYukle() {
        viewModelScope.launch {
            try {
                val response = yemeklerRepository.yemekleriYukle()
                yemeklerListesi.value = response
            } catch (e: Exception) {
                Log.e("YemekYukle","yemeklistesi yüklenmedi")
            }
        }
    }

    fun sepeteYemekEkle(kullaniciAdi: String,yemekler: Yemekler){

        CoroutineScope(Dispatchers.Main).launch {
                try {
                    sepetYemekler.value = yemeklerRepository.sepettekiYemekleriGetir(kullaniciAdi)
                    var sepetyemek = sepetYemekler.value.find { it.yemek_adi == yemekler.yemek_adi }
                    if (sepetyemek != null) {
                        yemeklerRepository.sepettenYemekSil(sepetyemek.sepet_yemek_id, kullaniciAdi)

                        yemeklerRepository.sepeteYemekEkle(
                            sepetyemek.yemek_adi,
                            sepetyemek.yemek_resim_adi,
                            sepetyemek.yemek_fiyat,
                            sepetyemek.yemek_siparis_adet + 1,
                            kullaniciAdi
                        )
                    } else {
                        yemeklerRepository.sepeteYemekEkle(
                            yemekler.yemek_adi,
                            yemekler.yemek_resim_adi,
                            yemekler.yemek_fiyat,
                            1,
                            kullaniciAdi
                        )
                    }

                } catch (e: EOFException) {
                    yemeklerRepository.sepeteYemekEkle(
                        yemekler.yemek_adi,
                        yemekler.yemek_resim_adi,
                        yemekler.yemek_fiyat,
                        1,
                        kullaniciAdi
                    )

                }



        }
    }


}




