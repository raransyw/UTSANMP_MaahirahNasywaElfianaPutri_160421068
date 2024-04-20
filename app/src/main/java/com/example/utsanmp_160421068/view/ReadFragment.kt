package com.example.utsanmp_160421068.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.utsanmp_160421068.R
import com.example.utsanmp_160421068.databinding.FragmentHomeBinding
import com.example.utsanmp_160421068.databinding.FragmentReadBinding
import com.example.utsanmp_160421068.model.Hobby
import com.example.utsanmp_160421068.viewModel.HobbyViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ReadFragment : Fragment() {
    private lateinit var viewModel: HobbyViewModel
    private lateinit var binding: FragmentReadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HobbyViewModel::class.java)
        val idnews = ReadFragmentArgs.fromBundle(requireArguments()).idNews
        viewModel.getHobby(idnews)

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.hobbyLD.observe(viewLifecycleOwner, Observer {
            var hobby = it
            Log.d("showit", it.toString())

                if(it!=null) {
                    binding.txtTitleDetail.setText(it.title)
                    binding.txtAuthor.setText(it.username)
                    binding.txtDescDetail.setText(it.desc)
                    binding.txtSubDetail.setText(it.sub)
                    Picasso.get().load(it.image_url).into(binding.imageDetail)
                }
        })
    }
}