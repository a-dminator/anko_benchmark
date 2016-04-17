package com.nethergrim.ankobenchmark.xml_only

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.nethergrim.ankobenchmark.R
import com.nethergrim.ankobenchmark.anko_only.AnkoActivity
import org.jetbrains.anko.intentFor

class XmlLayoutActivity : AppCompatActivity() {

    var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_layout)
        title = "Xml Activity"
        recycler = findViewById(R.id.recycler) as RecyclerView?;
        recycler?.layoutManager = LinearLayoutManager(this)
        recycler?.adapter = XmlAdapter()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu_main, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        startActivity(intentFor<AnkoActivity>())
        return true
    }
}
