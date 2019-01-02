package edu.gwu.rememberme

import android.app.AlertDialog
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.dialog_face.view.*

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.alert_menu, menu)
        return true
    }

    fun phoneButtonPressed(barpet: MenuItem) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_face_phone, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnOk.setOnClickListener {
            mAlertDialog.dismiss()
            val phone = mDialogView.editText.text.toString()

        }

        mDialogView.btnCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

    fun emailButtonPressed(barpet: MenuItem) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_face, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnOk.setOnClickListener {
            mAlertDialog.dismiss()
            val email = mDialogView.editText.text.toString()

        }

        mDialogView.btnCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

}
