package com.nethergrim.ankobenchmark.xml_only

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nethergrim.ankobenchmark.DataProvider
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.User

/**
 * Created by andrej on 17.04.16.
 */
class XmlAdapter: RecyclerView.Adapter<XmlViewHolder>() {

    var users: List<User> = DataProvider.provideUsers()

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): XmlViewHolder? {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.list_item, parent, false);
        val result = XmlViewHolder(view)
        return result
    }

    override fun onBindViewHolder(holder: XmlViewHolder?, position: Int) {
        holder?.bind(users[position])
    }
}