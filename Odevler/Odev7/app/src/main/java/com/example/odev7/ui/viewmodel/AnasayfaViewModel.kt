package com.example.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yapilacaklarRepository: YapilacaklarRepository) : ViewModel() {
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklariYukle()
    }

    fun sil(yapilacak_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarRepository.sil(yapilacak_id)
            yapilacaklariYukle()
        }
    }

    fun yapilacaklariYukle() {

        CoroutineScope(Dispatchers.Main).launch {
            val liste = yapilacaklarRepository.yapilacaklariYukle()
            Log.e("YapilacaklarYukle", "Veri sayısı: ${liste.size}")
            yapilacaklarListesi.value = yapilacaklarRepository.yapilacaklariYukle()//Tetikleme
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = yapilacaklarRepository.ara(aramaKelimesi)//Tetikleme
        }
    }
}