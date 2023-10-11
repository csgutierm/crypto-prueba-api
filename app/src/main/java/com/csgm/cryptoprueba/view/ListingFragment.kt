package com.csgm.cryptoprueba.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.csgm.cryptoprueba.MyViewModel
import com.csgm.cryptoprueba.databinding.FragmentListingBinding


class ListingFragment: Fragment() {

    private lateinit var binding: FragmentListingBinding

    private val viewModel by viewModels<MyViewModel>()

    private  lateinit var adapter: AssetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(inflater)
        initView()
        registerObserver()
        return binding.root//super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun initView(){
        adapter = AssetAdapter()
        binding.assetsList.adapter = adapter
        binding.assetsList.layoutManager = GridLayoutManager(context,1)
    }

    private fun registerObserver() {
        viewModel.assetList().observe(viewLifecycleOwner){
            Log.i("registerObserver", "datos $it")
            it?.let {
                adapter.update(it.data)
            }
        }
    }
}