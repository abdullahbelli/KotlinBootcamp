package com.example.odev7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.odev7.R
import com.example.odev7.databinding.FragmentYapilacakDetayBinding
import com.example.odev7.ui.viewmodel.YapilacakDetayViewModel
import com.example.odev7.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.getValue


@AndroidEntryPoint
class YapilacakDetayFragment : Fragment() {
    private lateinit var binding: FragmentYapilacakDetayBinding
    private lateinit var viewModel: YapilacakDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacakDetayBinding.inflate(inflater, container, false)
        val bundle :YapilacakDetayFragmentArgs by navArgs() // argüman ekleme işlemini unutmas
        val gelenYapilacak = bundle.yapilacak

        binding.editTextYapilacakAd.setText(gelenYapilacak.yapilacak_ad)

        binding.textViewYapilacak.setText(gelenYapilacak.yapilacak_ad)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacak_ad = binding.editTextYapilacakAd.text.toString()
            viewModel.guncelle(gelenYapilacak.yapilacak_id,yapilacak_ad)
            Toast.makeText(binding.root.context,"Güncellendi",Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                delay(1500)
                Navigation.gecisYap(it, R.id.detaydanAnasayfaya)
            }
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacakDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}