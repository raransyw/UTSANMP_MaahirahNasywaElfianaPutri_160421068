package com.example.utsanmp_160421068.view

import android.R.attr.name
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.utsanmp_160421068.databinding.ActivityLoginBinding
import com.example.utsanmp_160421068.viewModel.UserViewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: UserViewModel
    var username = ""
    var password = ""
    var login = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener{
            this.username = binding.txtUser.text.toString()
            this.password = binding.txtPassword.text.toString()
            viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            viewModel.getUsers()
            observeViewModel()
        }
        binding.btnRegist.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            for(user in it){
                if(user.username == this.username&&user.password == this.password){
                    login = true
                    val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                    val myEdit = sharedPreferences.edit()
                    myEdit.putInt("id", user.id)
                    myEdit.commit()
                    break
                }else{
                    login = false
                }
            }
            if(login){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Sorry invalid Username or Password",Toast.LENGTH_SHORT).show()
            }
        })
    }
}