package com.andromeda.belajarretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val results: ArrayList<MainModel.Result>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.textView.text = result.title
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