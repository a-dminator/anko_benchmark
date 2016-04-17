package com.nethergrim.ankobenchmark.anko_only

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.nethergrim.ankobenchmark.DataProvider

/**
 * Created by andrej on 17.04.16.
 */
class AnkoAdapter: RecyclerView.Adapter<AnkoViewHolder>() {

    val data = DataProvider.provideUsers()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AnkoViewHolder? {
        return AnkoViewHolder(ListItem(parent?.context))
    }

    override fun onBindViewHolder(holder: AnkoViewHolder?, position: Int) {
        holder?.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}