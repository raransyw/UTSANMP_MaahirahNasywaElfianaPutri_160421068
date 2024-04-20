package com.example.utsanmp_160421068.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.utsanmp_160421068.R
import com.example.utsanmp_160421068.databinding.ActivityLoginBinding
import com.example.utsanmp_160421068.databinding.ActivityMainBinding
import com.example.utsanmp_160421068.viewModel.HobbyViewModel
import com.example.utsanmp_160421068.viewModel.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: UserViewModel
    var username = ""
    var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener{
            this.username = binding.txtUser.text.toString()
            this.password = binding.txtPassword.text.toString()
        }
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUsers()
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            for(user in it){
                if(user.username == this.username&&user.password == this.password){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,"Sorry invalid Username or Password",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}