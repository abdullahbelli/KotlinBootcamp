package com.example.bitirmeprojesi.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.FragmentYemekDetayBinding
import com.example.bitirmeprojesi.ui.viewmodel.YemekDetayViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {
    private lateinit var binding: FragmentYemekDetayBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel: YemekDetayViewModel by viewModels()
    private lateinit var yemek: Yemekler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYemekDetayBinding.inflate(inflater, container, false)
        sharedPreferences = requireContext().getSharedPreferences("favoriler", Context.MODE_PRIVATE)

        arguments?.let {
            yemek = it.getSerializable("yemek") as Yemekler
        }

        resimGoster(yemek.yemek_resim_adi, binding.urunDetayResim)
        binding.urunDetayFiyat.text = "₺${yemek.yemek_fiyat}"
        binding.urunDetayAdet.setText("1")
        binding.urunDetayAd.text=yemek.yemek_adi

        guncelleToplamFiyat()

        binding.urunDetayAdetArttir.setOnClickListener {
            val adet = binding.urunDetayAdet.text.toString().toIntOrNull() ?: 1
            binding.urunDetayAdet.setText((adet + 1).toString())
            guncelleToplamFiyat()
        }

        binding.urunDetayAdetAzalt.setOnClickListener {
            val adet = binding.urunDetayAdet.text.toString().toIntOrNull() ?: 1
            if (adet > 1) {
                binding.urunDetayAdet.setText((adet - 1).toString())
                guncelleToplamFiyat()
            }
        }

        if (isFavorite(yemek.yemek_adi)) {
            binding.detayFavEkle.setImageResource(R.drawable.favori_resim)
        } else {
            binding.detayFavEkle.setImageResource(R.drawable.favori_degil_resim)
        }

        binding.detayFavEkle.setOnClickListener {
            val isFav = isFavorite(yemek.yemek_adi)
            sharedPreferences.edit().putBoolean(yemek.yemek_adi, !isFav).apply()
            binding.detayFavEkle.setImageResource(
                if (!isFav) R.drawable.favori_resim else R.drawable.favori_degil_resim
            )
            // Snackbar gösterimi:
            val message = if (!isFav) {
                "${yemek.yemek_adi} favorilere eklendi"
            } else {
                "${yemek.yemek_adi} favorilerden çıkarıldı"
            }
            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
        }


        binding.detaySepetEkle.setOnClickListener {
            val adet = binding.urunDetayAdet.text.toString().toIntOrNull() ?: 1
            viewModel.sepeteYemekEkle("AbdullahBelli", yemek, adet)
        }

        binding.detayKapat.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        return binding.root
    }

    private fun resimGoster(resimAdi: String, imageView: ImageView) {
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(requireContext()).load(url).override(300, 300).into(imageView)
    }

    private fun isFavorite(yemekAdi: String): Boolean {
        return sharedPreferences.getBoolean(yemekAdi, false)
    }

    private fun guncelleToplamFiyat() {
        val adet = binding.urunDetayAdet.text.toString().toIntOrNull() ?: 1
        val toplam = yemek.yemek_fiyat * adet
        binding.urunDetayToplamFiyat.text = "₺$toplam"
    }
}
