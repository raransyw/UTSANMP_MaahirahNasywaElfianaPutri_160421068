package com.example.utsanmp_160421068.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.utsanmp_160421068.R
import com.example.utsanmp_160421068.databinding.FragmentHomeBinding
import com.example.utsanmp_160421068.viewModel.HobbyViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: HobbyViewModel
    private lateinit var binding:FragmentHomeBinding
    private val HobbyAdapter = HobbyAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HobbyViewModel::class.java)
        viewModel.getHobbies()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = HobbyAdapter


        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.hobbiesLD.observe(viewLifecycleOwner, Observer {HobbyAdapter.updateHobbyList(it) })
    }
}