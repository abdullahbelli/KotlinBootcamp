package com.example.bitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.FavorilerCardTasarimBinding
import com.example.bitirmeprojesi.ui.viewmodel.FavorilerViewModel
import com.google.android.material.snackbar.Snackbar

class FavorilerAdapter(
    private val mContext: Context,
    var favoriYemekler: List<Yemekler>,
    private val viewModel: FavorilerViewModel
) : RecyclerView.Adapter<FavorilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val binding: FavorilerCardTasarimBinding) : RecyclerView.ViewHolder(binding.root)
    private var sharedPreferences = mContext.getSharedPreferences("favoriler", Context.MODE_PRIVATE)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = FavorilerCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = favoriYemekler[position]
        val t = holder.binding
        t.favoriUrunAd.text = yemek.yemek_adi
        t.favoriUrunFiyat.text = "₺${yemek.yemek_fiyat}"
        resimGoster(yemek.yemek_resim_adi, t.favoriUrunResim)

        if (isFavorite(yemek.yemek_adi))
            t.favButton.setImageResource(
                mContext.resources.getIdentifier("favori_resim", "drawable", mContext.packageName)
            )
        else
            t.favButton.setImageResource(
                mContext.resources.getIdentifier("favori_degil_resim", "drawable", mContext.packageName)
            )

        // Click listener
        t.favButton.setOnClickListener {
            val currentFav = isFavorite(yemek.yemek_adi)
            if (!currentFav) {
                // Favoriye ekle
                t.favButton.setImageResource(
                    mContext.resources.getIdentifier("favori_resim", "drawable", mContext.packageName)
                )
                sharedPreferences.edit().putBoolean(yemek.yemek_adi, true).apply()
                Snackbar.make(t.root, "${yemek.yemek_adi} favorilere eklendi", Snackbar.LENGTH_SHORT).show()
            } else {
                // Favoriden çıkar
                t.favButton.setImageResource(
                    mContext.resources.getIdentifier("favori_degil_resim", "drawable", mContext.packageName)
                )
                sharedPreferences.edit().putBoolean(yemek.yemek_adi, false).apply()
                Snackbar.make(t.root, "${yemek.yemek_adi} favorilerden çıkarıldı", Snackbar.LENGTH_SHORT).show()

                // Listeden çıkar ve notify et
                val index = favoriYemekler.indexOfFirst { it.yemek_adi == yemek.yemek_adi }
                if (index != -1) {
                    val mutableList = favoriYemekler.toMutableList()
                    mutableList.removeAt(index)
                    favoriYemekler = mutableList
                    notifyItemRemoved(index)
                    notifyItemRangeChanged(index, favoriYemekler.size)
                }
            }
        }
    }

    override fun getItemCount(): Int = favoriYemekler.size

    private fun resimGoster(resimAdi: String, imageView: ImageView) {
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(mContext).load(url).override(200, 200).into(imageView)
    }

    fun isFavorite(yemekAdi: String): Boolean {
        return sharedPreferences.getBoolean(yemekAdi, false)
    }
}
