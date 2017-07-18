package com.nethergrim.ankobenchmark.janko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nethergrim.ankobenchmark.R;
import com.nethergrim.ankobenchmark.anko_only.AnkoActivity;
import com.nethergrim.ankobenchmark.xml_only.XmlLayoutActivity;

import io.adev.janko.frameLayout;
import io.adev.janko.lparams;
import io.adev.janko.recyclerView;

import static android.support.v7.widget.RecyclerView.LayoutParams.MATCH_PARENT;

public class JankoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Janko activity");

        new frameLayout(this) {{

            new recyclerView(this) {{

                new lparams(MATCH_PARENT, MATCH_PARENT, this)._();

                layoutManager = new LinearLayoutManager(JankoActivity.this);
                adapter = new JankoAdapter();
                setHasFixedSize(true);

            }}._();

        }}._();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.xml: startActivity(new Intent(this, XmlLayoutActivity.class)); break;
            case R.id.anko: startActivity(new Intent(this, AnkoActivity.class)); break;
        }

        return true;
    }

}