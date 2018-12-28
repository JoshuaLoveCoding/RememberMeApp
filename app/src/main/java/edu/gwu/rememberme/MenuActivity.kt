package edu.gwu.rememberme

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private var homeFragment = HomeFragment()
    private var alertFragment = AlertFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                setFragment(alertFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        setFragment(homeFragment)
    }
}
