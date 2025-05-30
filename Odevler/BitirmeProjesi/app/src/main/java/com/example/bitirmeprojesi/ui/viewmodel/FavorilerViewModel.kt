package com.example.bitirmeprojesi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavorilerViewModel @Inject constructor(var repository: YemeklerRepository) : ViewModel() {
    val yemekler = MutableLiveData<List<Yemekler>>()
    val favoriYemekler = ArrayList<Yemekler>()

    init {
        yemeklerGetir()
    }

    fun yemeklerGetir() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemekler.value = repository.yemekleriYukle()
            } catch (e: Exception) {
                Log.e("Favoriler Hata", "Yemekler getirilemedi.", e)
            }
        }
    }
}
