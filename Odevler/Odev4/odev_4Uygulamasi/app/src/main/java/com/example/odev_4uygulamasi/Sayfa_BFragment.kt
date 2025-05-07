package com.example.odev_4uygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev_4uygulamasi.databinding.FragmentAnasayfaBinding
import com.example.odev_4uygulamasi.databinding.FragmentSayfaBBinding


class Sayfa_BFragment : Fragment() {
    private lateinit var binding: FragmentSayfaBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaBBinding.inflate(inflater, container, false)

        binding.button2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaBdenYyeGecis)
        }

        return binding.root
    }


}