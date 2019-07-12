package com.parka2.parka2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        item->
        when(item.itemId) {
            R.id.structures -> {
                replaceFragment(MapFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.lots -> {
                replaceFragment(LotsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.ride-> {
                replaceFragment(TheRideFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.options -> {
                replaceFragment(OptionsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(MapFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
