package com.nethergrim.ankobenchmark.janko;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.nethergrim.ankobenchmark.User;

import io.adev.janko.textView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static io.adev.janko.Janko.dip;

public class JankoViewHolder extends RecyclerView.ViewHolder {

    public JankoViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(User user) {
        ((ListItem) itemView).bind(user);
    }

    public static class ListItem extends RelativeLayout {

        public SimpleDraweeView imageView;
        public TextView text1;
        public TextView text2;
        public TextView text3;

        public ListItem(Context context) {
            super(context);

            imageView = new SimpleDraweeView(context);
            RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(dip(48), dip(48));
            imageParams.addRule(CENTER_VERTICAL);
            imageParams.setMarginStart(dip(16));
            imageView.setId(1);
            this.addView(imageView, imageParams);

            text1 = new textView(this) {{
                setId(2);
            }}._();

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params.addRule(RIGHT_OF, 1);
            params.addRule(ALIGN_TOP, 1);
            params.leftMargin = dip(16);
            text1.setLayoutParams(params);

            text2 = new textView(this) {{
                setId(3);
            }}._();

            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params2.addRule(RIGHT_OF, 1);
            params2.addRule(ALIGN_BOTTOM, 1);
            params2.addRule(BELOW, 2);
            params2.leftMargin = dip(16);
            text2.setLayoutParams(params2);


            text3 = new textView(this) {{

            }}._();

            RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params3.addRule(ALIGN_PARENT_RIGHT, -1);
            params3.topMargin = dip(8);
            params3.rightMargin = dip(16);
            text3.setLayoutParams(params3);

            this.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, dip(60)));
        }

        public void bind(User user) {
            imageView.setImageURI(Uri.parse(user.getAvatarUrl()), user);
            text1.setText(user.getName());
            text2.setText(user.getTitle());
            text3.setText(user.getLastSeen());
        }

    }



}