package com.example.kamalpreetsingh.musicplayer.activities

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.example.kamalpreetsingh.musicplayer.R
import com.example.kamalpreetsingh.musicplayer.adapters.NavigationDrawerAdapter
import com.example.kamalpreetsingh.musicplayer.fragments.MainScreenFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {
    var navigationDrawerIconsList: ArrayList<String> = arrayListOf()
    var images_for_navdrawer = intArrayOf(R.drawable.navigation_allsongs, R.drawable.navigation_favorites,
            R.drawable.navigation_settings, R.drawable.navigation_aboutus)

    object Statified {
        var drawerLayout: DrawerLayout? = null
    }



    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
        navigationDrawerIconsList.add("All songs")
        navigationDrawerIconsList.add("Favourites")
        navigationDrawerIconsList.add("Settings")
        navigationDrawerIconsList.add("About Us")

        var toolbar= findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        MainActivity.Statified.drawerLayout = findViewById(R.id.drawer_layout)
        val toggle=ActionBarDrawerToggle(this@MainActivity,MainActivity.Statified.drawerLayout,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        MainActivity.Statified.drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        val mainScreenFragment= MainScreenFragment()
        this.supportFragmentManager.beginTransaction()
                .add(R.id.details_fragment,mainScreenFragment,"MainScreenFragment").commit()

        val mnavigationAdapter = NavigationDrawerAdapter(navigationDrawerIconsList, images_for_navdrawer, this)
        mnavigationAdapter.notifyDataSetChanged()

        var navigation_recycler_view = findViewById<RecyclerView>(R.id.navigation)
        navigation_recycler_view.layoutManager = LinearLayoutManager(this)
        navigation_recycler_view.itemAnimator = DefaultItemAnimator()
        navigation_recycler_view.adapter = mnavigationAdapter
        navigation_recycler_view.setHasFixedSize(true)

        val intent= Intent(this@MainActivity, MainActivity::class.java)
        val pIntent= PendingIntent.getActivity(this@MainActivity, System.currentTimeMillis().toInt(),
                intent, 0)




    }
    override fun onStart() {
        super.onStart()
    }
}
