package com.example.utsanmp_160421068.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.utsanmp_160421068.databinding.HobbyListItemBinding
import com.example.utsanmp_160421068.model.Hobby
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class HobbyAdapter(val hobbyList: ArrayList<Hobby>)
    : RecyclerView.Adapter<HobbyAdapter.HobbyViewHolder>() {

    class HobbyViewHolder(var binding: HobbyListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        val binding = HobbyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HobbyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hobbyList.size
    }

    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        holder.binding.txtTitle.text = hobbyList[position].title
        holder.binding.txtAuthor.text = hobbyList[position].username
        holder.binding.txtDescDetail.text = hobbyList[position].desc
        holder.binding.btnRead.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToReadFragment(hobbyList[position].id)
            Navigation.findNavController(it).navigate(action)
        }

        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener {
                picasso, uri, exception -> exception.printStackTrace()
        }
        picasso.build().load(
            hobbyList[position].image_url).into(holder.binding.image, object : Callback {
            override fun onSuccess() {
                holder.binding.image.visibility = View.VISIBLE
            }

            override fun onError(e: Exception?) {
                Log.d("Cek", "Error")
            }
        })
    }

    fun updateHobbyList(newHobbyList: ArrayList<Hobby>){
        hobbyList.clear()
        hobbyList.addAll(newHobbyList)
        notifyDataSetChanged()
    }
}