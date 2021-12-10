package com.dsckiet.petapp.view.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dsckiet.petapp.R
import com.dsckiet.petapp.databinding.FragmentNewFeedBinding
import com.dsckiet.petapp.databinding.FragmentParticularChatBinding
import com.dsckiet.petapp.view.util.LocalKeyStorage
import com.dsckiet.petapp.view.viewmodel.ViewModel

import com.google.android.material.bottomnavigation.BottomNavigationView




class ParticularChatFragment : Fragment() {
    private lateinit var binding: FragmentParticularChatBinding
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentParticularChatBinding.inflate(layoutInflater)

        binding.particularChatToolbar.toolbarTitle.text = "Zoya"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cookie = LocalKeyStorage(requireContext()).getValue(LocalKeyStorage.COOKIE).toString()

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.MessagesList(cookie)
    }
}