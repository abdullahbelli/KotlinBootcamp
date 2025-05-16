package com.example.odev6

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.BannerTasarimBinding
import com.example.odev6.databinding.CardTasarimBinding


class BannerAdapter (var mContext: Context, var filmlerListesi: List<Filmler>) : RecyclerView.Adapter<BannerAdapter.BannerTasarimTutucu>() {


    inner class BannerTasarimTutucu(var tasarim: BannerTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerTasarimTutucu {
        var tasarim = BannerTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return BannerTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: BannerTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        val t = holder.tasarim

        t.bannerResim.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName)
        )

        Log.d("BannerAdapter", "Film adı: ${film.ad}")




    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}