package com.example.writearabic

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.writearabic.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Custom font
        val typeface = ResourcesCompat.getFont(this, R.font.blacklist)
        val appNameTextView = findViewById<TextView>(R.id.app_title)
        appNameTextView?.typeface = typeface

        // Animation
        val anim = AnimationUtils.loadAnimation(this, R.anim.myanim)
        appNameTextView?.startAnimation(anim)

        // Set an animation listener
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                // Animation started
            }

            override fun onAnimationEnd(animation: Animation?) {
                // Animation ended, start LoginActivity
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish() // Finish MainActivity so the user can't go back to it
            }

            override fun onAnimationRepeat(p0: Animation?) {
                // Animation ended
            }
        })
    }
}