package com.example.odev6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)




        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Atatürk","ataturk")
        val f2 = Filmler(2,"Atatürk 2","ataturk2")
        val f3 = Filmler(3,"Eşref Rüya","esref_ruya")
        val f4 = Filmler(4,"Küçük Bir Rica Daha","kucuk_bir_rica_daha")
        val f5 = Filmler(5,"Mukadderat","mukadderat")
        val f6 = Filmler(6,"Senden Başka","senden_baska")
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)


        val kategoriListesi = listOf(
            Basliklar(1, "Çok İzlenen Filmler"),
            Basliklar(2, "Dram Filmleri"),
            Basliklar(3, "Eski ve Değerli")
        )

        val filmMap = mapOf(
            1 to listOf(f1,f2,f3,f4,f5,f6),
            2 to listOf(f5,f6,f1,f2,f3,f4),
            3 to listOf(f3,f4,f5,f6,f1,f2)
        )

        val adapter = KategoriAdapter(requireContext(), kategoriListesi, filmMap)
        binding.filmlerRv.layoutManager = LinearLayoutManager(requireContext())
        binding.filmlerRv.adapter = adapter

        val bannerAdapter = BannerAdapter(requireContext(),filmlerListesi)
        binding.bannerRv.adapter = bannerAdapter

        binding.bannerRv.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)




        return binding.root
    }


}