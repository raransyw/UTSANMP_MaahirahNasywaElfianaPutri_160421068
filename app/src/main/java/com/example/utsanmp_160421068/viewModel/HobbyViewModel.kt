package com.example.utsanmp_160421068.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.utsanmp_160421068.model.Hobby
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HobbyViewModel (application: Application): AndroidViewModel(application){
    var hobbiesLD = MutableLiveData<ArrayList<Hobby>>()
    var hobbyLD = MutableLiveData<Hobby>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun getHobbies(){
        // bisa cari dari volley
        //query db sqLite
        //xml
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/UTSANMP/connection_news.php"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url, {

                val sType = object : TypeToken<List<Hobby>>() {}.type
                val result = Gson().fromJson<List<Hobby>>(it, sType)
                hobbiesLD.value = result as ArrayList<Hobby>?

                Log.d("showvolley", it)

            },
            {
                Log.d("showvolley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun getHobby(id:Int){
        // bisa cari dari volley
        //query db sqLite
        //xml
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/UTSANMP/connection_newsbyid.php?id=${id}"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url, {
                Log.d("showit", it)

                val result = Gson().fromJson<Hobby>(it, Hobby::class.java)
                hobbyLD.value = result



            },
            {
                Log.d("showit", it.toString())
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