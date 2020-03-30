package com.joel.agoraprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.agora_action_bar.*
import kotlinx.android.synthetic.main.agora_action_bar.view.*

class MainActivity : AppCompatActivity() {

    lateinit var snackbar : Snackbar
    lateinit var navController: NavController

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
    }
}
