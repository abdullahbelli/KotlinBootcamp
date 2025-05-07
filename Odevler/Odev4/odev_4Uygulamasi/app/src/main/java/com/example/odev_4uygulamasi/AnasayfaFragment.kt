package com.example.odev_4uygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev_4uygulamasi.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonAGecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaAGecis)
        }

        binding.buttonXGecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaXGecis)
        }



        return binding.root
    }


}