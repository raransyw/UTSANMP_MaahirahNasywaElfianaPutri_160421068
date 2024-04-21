package com.example.utsanmp_160421068.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.utsanmp_160421068.model.Users
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class UserViewModel (application: Application): AndroidViewModel(application){
    var statusLD = MutableLiveData<String>()
    var userLD = MutableLiveData<ArrayList<Users>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun getUsers(){
        // bisa cari dari volley
        //query db sqLite
        //xml
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/UTSANMP/connection_user.php"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url, {

                val sType = object : TypeToken<List<Users>>() {}.type
                val result = Gson().fromJson<List<Users>>(it, sType)
                userLD.value = result as ArrayList<Users>?

                Log.d("showvolley", it)

            },
            {
                Log.d("showvolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun updateUser(id:Int, username:String, first_name: String,last_name: String,password: String){
        // bisa cari dari volley
        //query db sqLite
        //xml
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/UTSANMP/connection_updateuser.php?id=${id}&username=${username}&first_name=${first_name}&last_name=${last_name}&password=${password}"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url, {

                var obj = JSONObject(it)
                var result = obj.getString("status")
                if (result == "success") {
                    statusLD
                }
                else{
                    statusLD

                }
                Log.d("showvolley", it)

            },
            {
                Log.d("showvolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    fun addUser(username: String,first_name:String,last_name:String,email:String,password:String){
        // bisa cari dari volley
        //query db sqLite
        //xml
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/UTSANMP/connection_newuser.php?username=${username}&first_name=${first_name}&last_name=${last_name}&email=${email}&password=${password}"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url, {

                val sType = object : TypeToken<List<Users>>() {}.type
                val result = Gson().fromJson<List<Users>>(it, sType)
                userLD.value = result as ArrayList<Users>?

                Log.d("showvolley", it)

            },
            {
                Log.d("showvolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}