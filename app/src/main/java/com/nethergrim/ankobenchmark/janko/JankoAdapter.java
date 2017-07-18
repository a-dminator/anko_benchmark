package com.nethergrim.ankobenchmark.janko;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nethergrim.ankobenchmark.DataProvider;
import com.nethergrim.ankobenchmark.User;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class JankoAdapter extends RecyclerView.Adapter<JankoViewHolder> {

    public List<User> data = DataProvider.INSTANCE.provideUsers();
    public List<Integer> timeRecords = new ArrayList<>(50);

    @Override
    public JankoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        long now = System.currentTimeMillis();
        JankoViewHolder result = new JankoViewHolder(new JankoViewHolder.ListItem(parent.getContext()));
        timeRecords.add((int)(System.currentTimeMillis() - now));
        return result;
    }

    @Override
    public void onBindViewHolder(JankoViewHolder holder, int position) {
        holder.bind(data.get(position));
        if (position == data.size() - 1){
            Log.d("anko", "reached the end");
            long min = CollectionsKt.min(timeRecords);
            long max = CollectionsKt.max(timeRecords);
            double avg = CollectionsKt.averageOfInt(timeRecords);
            String out = "min: " + min + " ms, max: " + max + " ms, avg: " + avg + " ms";
            Toast.makeText(holder.itemView.getContext(), "Janko " + out, Toast.LENGTH_LONG).show();
            Log.e("Janko", out);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}