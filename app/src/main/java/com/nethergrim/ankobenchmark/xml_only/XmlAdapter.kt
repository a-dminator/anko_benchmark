package com.nethergrim.ankobenchmark.xml_only

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.nethergrim.ankobenchmark.DataProvider
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.User
import java.util.*

/**
 * Created by andrej on 17.04.16.
 */
class XmlAdapter: RecyclerView.Adapter<XmlViewHolder>() {

    var users: List<User> = DataProvider.provideUsers()
    var timeRecords = ArrayList<Int>(50)

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): XmlViewHolder? {
        val now = System.currentTimeMillis()
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.list_item, parent, false);
        val result = XmlViewHolder(view)
        timeRecords.add((System.currentTimeMillis() - now).toInt())
        return result
    }

    override fun onBindViewHolder(holder: XmlViewHolder?, position: Int) {
        holder?.bind(users[position])
        if (position == users.size - 1){
            Log.d("xml", "reached the end")
            val min = timeRecords.min()
            val max = timeRecords.max()
            val avg = timeRecords.average()
            Toast.makeText(holder?.itemView?.context,"ANKO\nmin: $min, max: $max, avg: $avg" , Toast.LENGTH_LONG).show()
        }
    }
}