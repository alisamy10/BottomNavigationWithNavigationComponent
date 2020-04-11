package com.omni.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.ui.adapter.HomeRecycleAdapter
import com.omni.myapplication.R
import com.omni.myapplication.data.DataSource
import com.omni.myapplication.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var homeViewModel: HomeViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val adapter = HomeRecycleAdapter()
        rec.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        rec.adapter = adapter

        homeViewModel.getData().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })



    }
}