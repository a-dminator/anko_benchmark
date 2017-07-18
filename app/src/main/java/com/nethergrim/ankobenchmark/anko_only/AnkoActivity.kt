package com.nethergrim.ankobenchmark.anko_only

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.janko.JankoActivity
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by andrej on 17.04.16.
 */
class AnkoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Anko activity"
        frameLayout {

            recyclerView {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@AnkoActivity)
                adapter = AnkoAdapter()
            }.lparams { width = -1; height = -1 }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu_main, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.xml -> startActivity(intentFor<AnkoActivity>())
            R.id.janko -> startActivity(intentFor<JankoActivity>())
        }

        return true
    }

}