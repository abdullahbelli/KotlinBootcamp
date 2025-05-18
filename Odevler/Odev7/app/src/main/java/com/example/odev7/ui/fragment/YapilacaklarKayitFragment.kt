package com.example.odev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.odev7.R
import com.example.odev7.databinding.FragmentAnasayfaBinding
import com.example.odev7.databinding.FragmentYapilacaklarKayitBinding
import com.example.odev7.ui.viewmodel.AnasayfaViewModel
import com.example.odev7.ui.viewmodel.YapilacaklarKayitViewModel
import com.example.odev7.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class YapilacaklarKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaklarKayitBinding
    private lateinit var viewModel: YapilacaklarKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentYapilacaklarKayitBinding.inflate(inflater, container, false)


        binding.buttonKaydet.setOnClickListener {
            val yapilacak_ad = binding.editTextYapilacakAd.text.toString()
            viewModel.kaydet(yapilacak_ad)
            Toast.makeText(binding.root.context,"Kaydedildi", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                delay(1500)
                Navigation.gecisYap(it, R.id.kayittanAnasyafaya)
            }
        }




        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

}