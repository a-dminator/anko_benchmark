package com.nethergrim.ankobenchmark.anko_only

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import com.nethergrim.ankobenchmark.DataProvider
import java.util.*

/**
 * Created by andrej on 17.04.16.
 */
class AnkoAdapter: RecyclerView.Adapter<AnkoViewHolder>() {

    val data = DataProvider.provideUsers()

    var timeRecords = ArrayList<Int>(50)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AnkoViewHolder? {
        val now = System.currentTimeMillis()
        val result = AnkoViewHolder(ListItem(parent?.context))
        timeRecords.add((System.currentTimeMillis() - now).toInt())
        return result
    }

    override fun onBindViewHolder(holder: AnkoViewHolder?, position: Int) {
        holder?.bind(data[position])
        if (position == data.size - 1){
            Log.d("anko", "reached the end")
            val min = timeRecords.min()
            val max = timeRecords.max()
            val avg = timeRecords.average()
            val out = "min: $min ms, max: $max ms, avg: $avg ms"
            Toast.makeText(holder?.itemView?.context,"Anko $out" , Toast.LENGTH_LONG).show()
            Log.e("Anko", out);
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}