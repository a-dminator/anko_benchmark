package com.nethergrim.ankobenchmark.xml_only

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.User
import org.jetbrains.anko.find

/**
 * Created by andrej on 17.04.16.
 */
class XmlViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var image: SimpleDraweeView? = null
    var text1: TextView? = null
    var text2: TextView? = null
    var text3: TextView? = null

    init {
        image = itemView?.find<SimpleDraweeView>(R.id.image)
        text1 = itemView?.find<TextView>(R.id.text1)
        text2 = itemView?.find<TextView>(R.id.text2)
        text3 = itemView?.find<TextView>(R.id.text3)
    }

    fun bind(user: User) {
        image?.setImageURI(Uri.parse(user.avatarUrl), user)
        text1?.text = user.name
        text2?.text = user.title
        text3?.text = user.lastSeen
    }

}