package com.example.bitirmeprojesi.ui.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitirmeprojesi.databinding.FragmentSepetBinding
import com.example.bitirmeprojesi.ui.adapter.SepetAdapter
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private val viewModel: SepetViewModel by viewModels()
    private lateinit var adapter: SepetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        adapter = SepetAdapter(requireContext(), emptyList(), viewModel)
        binding.sepetRV.adapter = adapter
        binding.sepetRV.layoutManager = LinearLayoutManager(requireContext())

        viewModel.sepetYemekler.observe(viewLifecycleOwner) { sepetListesi ->
            adapter.sepetYemekler = sepetListesi
            adapter.notifyDataSetChanged()
        }

        viewModel.sepetYemeklerTutar.observe(viewLifecycleOwner) { toplamTutar ->
            toplamTutarYaz(toplamTutar)
        }

        binding.button.setOnClickListener { view ->
            binding.lottieAnimationView.apply {
                visibility = View.VISIBLE
                playAnimation()
                addAnimatorListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        visibility = View.GONE

                    }
                })
            }
        }


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepettekiYemekleriYukle()
    }

    private fun toplamTutarYaz(tutar: Int) {
        binding.sepetToplamFiyat.text = "₺$tutar"
    }
}
