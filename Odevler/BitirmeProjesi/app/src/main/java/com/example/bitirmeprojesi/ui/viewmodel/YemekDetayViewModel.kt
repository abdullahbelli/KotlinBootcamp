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
class YemekDetayViewModel @Inject constructor(private val repository: YemeklerRepository) : ViewModel() {

    var yemeklerList = MutableLiveData<List<Yemekler>>()
    var sepetYemekler = MutableLiveData<List<SepetYemekler>>()

    init {
        yemekleriYukle()
    }

    fun yemekleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemeklerList.value = repository.yemekleriYukle()
            } catch (e: Exception) {
                Log.e("YemeklerYukle", "Yemek listesi getirilemedi", e)
            }
        }
    }

    fun sepeteYemekEkle(kullaniciAdi: String, yemekler: Yemekler, miktar: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetYemekler.value = repository.sepettekiYemekleriGetir(kullaniciAdi)
                val sepetyemek = sepetYemekler.value?.find { it.yemek_adi == yemekler.yemek_adi }

                if (sepetyemek != null) {
                    repository.sepettenYemekSil(sepetyemek.sepet_yemek_id, kullaniciAdi)
                    repository.sepeteYemekEkle(
                        sepetyemek.yemek_adi,
                        sepetyemek.yemek_resim_adi,
                        sepetyemek.yemek_fiyat,
                        sepetyemek.yemek_siparis_adet + miktar,
                        kullaniciAdi
                    )
                } else {
                    repository.sepeteYemekEkle(
                        yemekler.yemek_adi,
                        yemekler.yemek_resim_adi,
                        yemekler.yemek_fiyat,
                        miktar,
                        kullaniciAdi
                    )
                }
            } catch (e: Exception) {
                repository.sepeteYemekEkle(
                    yemekler.yemek_adi,
                    yemekler.yemek_resim_adi,
                    yemekler.yemek_fiyat,
                    miktar,
                    kullaniciAdi
                )
            }
        }
    }

    fun sepetAdetAzalt(yemekler: SepetYemekler) {
        CoroutineScope(Dispatchers.Main).launch {
            if (yemekler.yemek_siparis_adet > 1) {
                repository.sepettenYemekSil(yemekler.sepet_yemek_id, "AbdullahBelli")
                repository.sepeteYemekEkle(
                    yemekler.yemek_adi,
                    yemekler.yemek_resim_adi,
                    yemekler.yemek_fiyat,
                    yemekler.yemek_siparis_adet - 1,
                    "AbdullahBelli"
                )
            } else {
                repository.sepettenYemekSil(yemekler.sepet_yemek_id, "AbdullahBelli")
            }
        }
    }

    fun sepetAdetArttir(kullaniciAdi: String, yemekler: SepetYemekler) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetYemekler.value = repository.sepettekiYemekleriGetir(kullaniciAdi)
                val sepetYemek = sepetYemekler.value?.find { it.yemek_adi == yemekler.yemek_adi }

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
        }
    }
}
