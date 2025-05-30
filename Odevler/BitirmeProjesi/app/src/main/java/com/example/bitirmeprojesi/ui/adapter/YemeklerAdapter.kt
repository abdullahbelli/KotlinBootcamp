package com.example.bitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.CardTasarimBinding
import com.example.bitirmeprojesi.ui.fragment.AnasayfaFragmentDirections
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel
import com.example.bitirmeprojesi.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class YemeklerAdapter (var mContext: Context,
    var yemekListesi: List<Yemekler>,
    var viewModel: AnasayfaViewModel)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>(){
    private var sharedPreferences=mContext.getSharedPreferences("favoriler", Context.MODE_PRIVATE)

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemekListesi.get(position)
        val t = holder.tasarim

        t.urunAd.text = yemek.yemek_adi
        t.urunFiyat.text ="₺" + yemek.yemek_fiyat.toString()
        resimGoster(yemek.yemek_resim_adi,t.urunResim)

        t.anasayfaCard.setOnClickListener{
            val action= AnasayfaFragmentDirections.yemekAnasayfaDetayGecis(yemek)
            Navigation.gecisYap(it,action)
        }

        t.sepeteEkleButton.setOnClickListener{
            viewModel.sepeteYemekEkle("AbdullahBelli",yemek)
            Snackbar.make(t.root,"${yemek.yemek_adi} sepete eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        if (isFavorite(yemek.yemek_adi))
            t.favEkleButton.setImageResource(
                mContext.resources.getIdentifier("favori_resim", "drawable", mContext.packageName)
            )
        else
            t.favEkleButton.setImageResource(
                mContext.resources.getIdentifier("favori_degil_resim", "drawable", mContext.packageName)
            )

        // Click listener
        t.favEkleButton.setOnClickListener {
            val currentFav = isFavorite(yemek.yemek_adi)
            if (!currentFav) {
                t.favEkleButton.setImageResource(
                    mContext.resources.getIdentifier("favori_resim", "drawable", mContext.packageName)
                )
                sharedPreferences.edit().putBoolean(yemek.yemek_adi, true).apply()
                Snackbar.make(t.root, "${yemek.yemek_adi} favorilere eklendi", Snackbar.LENGTH_SHORT).show()
            } else {
                t.favEkleButton.setImageResource(
                    mContext.resources.getIdentifier("favori_degil_resim", "drawable", mContext.packageName)
                )
                sharedPreferences.edit().putBoolean(yemek.yemek_adi, false).apply()
                Snackbar.make(t.root, "${yemek.yemek_adi} favorilerden çıkarıldı", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }

    fun isFavorite(yemekAdi: String): Boolean{
        return sharedPreferences.getBoolean(yemekAdi,false)
    }

    fun resimGoster(resimAdi: String, imageView: ImageView){
        val url="http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(mContext).load(url).override(200,200).into(imageView)
    }
}