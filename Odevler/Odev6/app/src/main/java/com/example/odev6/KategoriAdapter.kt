package com.example.odev6
import FilmlerAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.CardTasarimBinding
import androidx.recyclerview.widget.LinearLayoutManager


class KategoriAdapter(
    val mContext: Context,
    val kategoriListesi: List<Basliklar>,
    val filmVerileri: Map<Int, List<Filmler>> // id → film listesi
) : RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>() {

    inner class KategoriViewHolder(val tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriViewHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return KategoriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KategoriViewHolder, position: Int) {
        val kategori = kategoriListesi[position]
        val t = holder.tasarim

        t.cardBaslik.text = kategori.baslik

        val altFilmListesi = filmVerileri[kategori.id] ?: emptyList()
        val adapter = FilmlerAdapter(mContext, altFilmListesi)
        t.filmlerRv.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, true)
        t.filmlerRv.adapter = adapter
    }

    override fun getItemCount(): Int = kategoriListesi.size
}

