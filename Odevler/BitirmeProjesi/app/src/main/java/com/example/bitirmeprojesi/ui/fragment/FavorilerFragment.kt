package com.example.bitirmeprojesi.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bitirmeprojesi.databinding.FragmentFavorilerBinding
import com.example.bitirmeprojesi.ui.adapter.FavorilerAdapter
import com.example.bitirmeprojesi.ui.viewmodel.FavorilerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavorilerFragment : Fragment() {
    private lateinit var binding: FragmentFavorilerBinding
    private val viewModel: FavorilerViewModel by viewModels() // <- BU ŞART
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var favorilerAdapter: FavorilerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavorilerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("favoriler", Context.MODE_PRIVATE)

        favorilerAdapter = FavorilerAdapter(requireContext(), emptyList(), viewModel)
        binding.favorilerRV.adapter = favorilerAdapter
        binding.favorilerRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.yemekler.observe(viewLifecycleOwner) { yemeklerListesi ->
            if (yemeklerListesi != null && yemeklerListesi.isNotEmpty()) {
                val favorilerListesi = yemeklerListesi.filter { yemek ->
                    sharedPreferences.getBoolean(yemek.yemek_adi, false)
                }
                viewModel.favoriYemekler.clear()
                viewModel.favoriYemekler.addAll(favorilerListesi)

                favorilerAdapter.favoriYemekler = favorilerListesi
                favorilerAdapter.notifyDataSetChanged()
            } else {
                viewModel.favoriYemekler.clear()
                favorilerAdapter.favoriYemekler = emptyList()
                favorilerAdapter.notifyDataSetChanged()
            }
        }
    }
}