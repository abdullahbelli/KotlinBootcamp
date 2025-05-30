package com.example.bitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bitirmeprojesi.data.entity.SepetYemekler
import com.example.bitirmeprojesi.databinding.CardTasarimBinding
import com.example.bitirmeprojesi.databinding.CardTasarimSepetBinding

import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel

class SepetAdapter (var mContext: Context,
    var sepetYemekler: List<SepetYemekler>,
    var viewModel: SepetViewModel) : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var sepetCardTasarimSepetBinding: CardTasarimSepetBinding) : RecyclerView.ViewHolder(sepetCardTasarimSepetBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardTasarimTutucu {
        val sepetCard = CardTasarimSepetBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(sepetCard)
    }

    override fun onBindViewHolder(holder: SepetAdapter.CardTasarimTutucu, position: Int) {
        val t = holder.sepetCardTasarimSepetBinding
        val yemek = sepetYemekler.get(position)
        t.sepetUrunAd.text=yemek.yemek_adi
        t.sepetUrunFiyat.text="₺"+(yemek.yemek_fiyat*yemek.yemek_siparis_adet).toString()
        t.sepetUrunAdet.text = yemek.yemek_siparis_adet.toString()
        resimGoster(yemek.yemek_resim_adi,t.sepetUrunResim)

        t.sepetUrunSil.setOnClickListener{
            viewModel.sepettenYemekSil(yemek)
        }

        t.sepetAdetArttir.setOnClickListener{
            viewModel.sepetAdetArttir("AbdullahBelli",yemek)
        }

        t.sepetAdetAzalt.setOnClickListener{
            viewModel.sepetAdetAzalt(yemek)
        }



    }

    override fun getItemCount(): Int {
        return sepetYemekler.size
    }

    fun resimGoster(resimAdi: String, imageView: ImageView){
        val url="http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(mContext).load(url).override(200,200).into(imageView)
    }

}





