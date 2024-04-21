package com.example.utsanmp_160421068.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.utsanmp_160421068.R
import com.example.utsanmp_160421068.databinding.FragmentProfileBinding
import com.example.utsanmp_160421068.databinding.FragmentReadBinding
import com.example.utsanmp_160421068.viewModel.HobbyViewModel
import com.example.utsanmp_160421068.viewModel.UserViewModel

class ProfileFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: FragmentProfileBinding
    var username = ""
    var password = ""
    var first = ""
    var last = ""
    var save = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
            this.username = binding.txtUser.text.toString()
            this.password = binding.txtPassword.text.toString()
            this.first = binding.txtFirst.text.toString()
            this.last = binding.txtLast.text.toString()
            save = true
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.updateUser(id,username, last,first,password)
            observeViewModel()
        }
    }

}