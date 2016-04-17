package com.nethergrim.ankobenchmark.anko_only

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.nethergrim.ankobenchmark.User
import org.jetbrains.anko.centerVertically
import org.jetbrains.anko.dip
import org.jetbrains.anko.textView

/**
 * Created by andrej on 17.04.16.
 */
class AnkoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User) {
        (itemView as ListItem).bind(user)
    }
}

class ListItem(context: Context?) : RelativeLayout(context) {

    var imageView: SimpleDraweeView? = null
    var text1: TextView? = null
    var text2: TextView? = null
    var text3: TextView? = null

    init {
        imageView = SimpleDraweeView(context).apply { }
        val imageParams = RelativeLayout.LayoutParams(dip(48), dip(48))
        imageParams.centerVertically()
        imageParams.marginStart = dip(16)
        imageView?.id = 1
        this.addView(imageView, imageParams)

        this.apply {

            text1 = textView { id = 2 }
            var params: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(-2, -2)
            params.apply {
                addRule(RelativeLayout.RIGHT_OF, 1)
                addRule(RelativeLayout.ALIGN_TOP, 1)
                leftMargin = dip(16)
            }
            text1?.layoutParams = params


            text2 = textView { id = 3 }
            var params2: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(-2, -2)
            params2.apply {
                addRule(RelativeLayout.RIGHT_OF, 1)
                addRule(RelativeLayout.ALIGN_BOTTOM, 1)
                addRule(RelativeLayout.BELOW, 2)
                leftMargin = dip(16)
            }
            text2?.layoutParams = params2


            text3 = textView { id = 4 }


            var params3: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(-2, -2)
            params3.apply {
                addRule(RelativeLayout.ALIGN_PARENT_RIGHT, -1)
                topMargin = dip(8)
                rightMargin = dip(16)
            }
            text3?.layoutParams = params3
        }
        this.layoutParams = ViewGroup.LayoutParams(-1, dip(60))
    }

    fun bind(user: User) {
        imageView?.setImageURI(Uri.parse(user.avatarUrl), user)
        text1?.text = user.name
        text2?.text = user.title
        text3?.text = user.lastSeen
    }
}

