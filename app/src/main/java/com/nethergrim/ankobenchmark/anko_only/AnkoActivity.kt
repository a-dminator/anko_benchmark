package com.nethergrim.ankobenchmark.anko_only

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.frameLayout
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

}