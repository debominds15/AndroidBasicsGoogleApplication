package com.example.testapplication.login.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.testapplication.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "Home"

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().replace(R.id.flContent, HomeFragment()).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment : Fragment = HomeFragment()
        when (item.itemId) {
            R.id.nav_home_fragment -> {
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                fragment = HomeFragment()
            }
            R.id.nav_profile_fragment -> {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                setTitle("Home")
            }
            R.id.nav_help -> {
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show()
                setTitle("Home")
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()
        toolbar?.title = item.getTitle()
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}