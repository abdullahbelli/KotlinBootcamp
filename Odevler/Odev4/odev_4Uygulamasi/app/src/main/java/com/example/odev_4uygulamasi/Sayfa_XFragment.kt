package com.example.odev_4uygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev_4uygulamasi.databinding.FragmentAnasayfaBinding
import com.example.odev_4uygulamasi.databinding.FragmentSayfaXBinding


class Sayfa_XFragment : Fragment() {
    private lateinit var binding: FragmentSayfaXBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaXBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaXtenYyeGecis)
        }

        return binding.root
    }


}