package com.example.odev_4uygulamasi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.odev_4uygulamasi.databinding.FragmentAnasayfaBinding
import com.example.odev_4uygulamasi.databinding.FragmentSayfaYBinding


class Sayfa_YFragment : Fragment() {
    private lateinit var binding: FragmentSayfaYBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSayfaYBinding.inflate(inflater, container, false)

        val geriTusu = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.e("Detay sayfa", "Geri tuşu çalıştı")

                val intent = Intent(requireContext(), MainActivity::class.java)

                startActivity(intent)
                requireActivity().finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, geriTusu)


        return binding.root
    }


}