package com.example.utsanmp_160421068.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.utsanmp_160421068.R
import com.example.utsanmp_160421068.databinding.ActivityLoginBinding
import com.example.utsanmp_160421068.databinding.ActivityRegisterBinding
import com.example.utsanmp_160421068.viewModel.UserViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: UserViewModel
    var username = ""
    var password = ""
    var email = ""
    var first = ""
    var last = ""
    var regist = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            this.username = binding.txtUser.text.toString()
            this.password = binding.txtPassword.text.toString()
            this.email = binding.txtEmail.text.toString()
            this.first = binding.txtFirst.text.toString()
            this.last = binding.txtLast.text.toString()
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.addUser(username,first,last,email,password)
            observeViewModel()
        }
    }
    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            Log.d("check",it.toString())
            for(user in it){
                if(user.username == this.username&&user.password == this.password){
                    regist = true
                    break
                }else{
                    regist = false
                }
            }
            if(regist){
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Sorry invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        })
    }
}