package com.andromeda.belajarretrofit

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private val results: ArrayList<MainModel.Result>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.textView.text = result.title

        Log.d("MainAdapter", "resultImage: ${result.image}")
        Glide.with(holder.imageView)
            .load(result.image)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .centerCrop()
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return  results.size
    }

    fun setData(data: ArrayList<MainModel.Result>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }
}