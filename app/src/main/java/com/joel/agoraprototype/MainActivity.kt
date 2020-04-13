package com.joel.agoraprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.createelection.CreateElectionOne
import com.joel.agoraprototype.profileSetting.ProfileSettings
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.agora_action_bar.*
import kotlinx.android.synthetic.main.agora_action_bar.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var snackbar : Snackbar
    lateinit var navController: NavController
    lateinit var navigationView: NavigationView
    private var isOpen: Boolean = false
    lateinit var openAnimation: Animation
    lateinit var closeAnimation: Animation
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customActionBar()
        /*
            welcome message for users logging in
            will not show if user is already logged (below code shows everytime, but this is just for simulation)
         */
        snackbar = Snackbar.make(layout_main_activity, "Welcome to Agora Vote", Snackbar.LENGTH_SHORT)
        snackbar.show()

        //bottom navigation
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottom_navigation, navController)

        //animation for fab
        openAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        closeAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        //Floating action button main with animation
        main_fab.setOnClickListener {
            if (isOpen) {
                extend_fab1.animation = closeAnimation
                extend_fab2.animation = closeAnimation
                fab_create_election_text.visibility = View.INVISIBLE
                fab_create_poll_text.visibility = View.INVISIBLE
                isOpen = false
            } else {
                extend_fab1.animation = openAnimation
                extend_fab2.animation = openAnimation
                fab_create_election_text.visibility = View.VISIBLE
                fab_create_poll_text.visibility = View.VISIBLE
                isOpen = true
            }
        }

        //create election fab
        extend_fab2.setOnClickListener {
            startActivity(Intent(this@MainActivity, CreateElectionOne::class.java))
        }

    }

    //function to modify actionbar
    private fun customActionBar() {
        var toolbar: Toolbar = findViewById(R.id.main_custom_action_bar) as Toolbar
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        //here the username will replace 'Joel'
        toolbar.action_bar_title.text = "Welcome, Joel"
        toolbar.action_bar_profile_pic.setOnClickListener {
            //sliding profile menu
            navigationView = findViewById(R.id.profile_sliding_drawer)
            drawerLayout = findViewById(R.id.layout_main_activity)
            drawerLayout.openDrawer(GravityCompat.START)
            var actionBarDrawerToggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                action_bar,
                R.string.nav_open,
                R.string.nav_close
            )
            drawerLayout.addDrawerListener(actionBarDrawerToggle)
            actionBarDrawerToggle.syncState()
            navigationView.setNavigationItemSelectedListener(this)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_profile_settings -> startActivity(Intent(this@MainActivity, ProfileSettings::class.java))
        }
        item.setChecked(true)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}


