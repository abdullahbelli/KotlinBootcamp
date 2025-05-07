package com.example.odev_4uygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev_4uygulamasi.databinding.FragmentAnasayfaBinding
import com.example.odev_4uygulamasi.databinding.FragmentSayfaABinding


class Sayfa_AFragment : Fragment() {
    private lateinit var binding: FragmentSayfaABinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaABinding.inflate(inflater, container, false)

        binding.buttonBGecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaAdanByeGecis)
        }

        return binding.root
    }


}