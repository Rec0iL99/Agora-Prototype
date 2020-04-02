package com.joel.agoraprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.agora_action_bar.*
import kotlinx.android.synthetic.main.agora_action_bar.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var snackbar : Snackbar
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

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
    }

    //function to modify actionbar
    private fun customActionBar() {
        var toolbar: Toolbar = findViewById(R.id.main_custom_action_bar) as Toolbar
        setSupportActionBar(toolbar)
        //here the username will replace 'Joel'
        toolbar.action_bar_title.text = "Welcome, Joel"
        toolbar.action_bar_profile_pic.setOnClickListener {
            //sliding profile menu
            navigationView = findViewById(R.id.profile_sliding_drawer)
            layout_main_activity.openDrawer(GravityCompat.START)
            var actionBarDrawerToggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
                this,
                layout_main_activity,
                action_bar,
                R.string.nav_open,
                R.string.nav_close
            )
            layout_main_activity.addDrawerListener(actionBarDrawerToggle)
            actionBarDrawerToggle.syncState()
            navigationView.setNavigationItemSelectedListener(this)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
