package com.nethergrim.ankobenchmark.xml_only

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.User

/**
 * Created by andrej on 17.04.16.
 */
class XmlViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var image: SimpleDraweeView? = null
    var text1: TextView? = null
    var text2: TextView? = null
    var text3: TextView? = null

    init {
        image = itemView?.findViewById(R.id.image) as SimpleDraweeView?;
        text1 = itemView?.findViewById(R.id.text1) as TextView?;
        text2 = itemView?.findViewById(R.id.text2) as TextView?;
        text3 = itemView?.findViewById(R.id.text3) as TextView?;
    }

    fun bind(user: User) {
        image?.setImageURI(Uri.parse(user.avatarUrl), user)
        text1?.text = user.name
        text2?.text = user.title
        text3?.text = user.lastSeen
    }
}