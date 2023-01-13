package com.example.home

import android.os.Bundle
import android.view.View
import com.example.core_ui.base.BindingFragment
import com.example.todaysweather.feature.R
import com.example.todaysweather.feature.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}