package com.ridefast.autoaccept

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(40, 60, 40, 40)
        }

        val title = TextView(this).apply {
            text = "RideFast Auto Accept"
            textSize = 28f
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Android 16 diagnostic build"
            textSize = 18f
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 40)
        }

        val status = TextView(this).apply {
            text = if (ServiceState.isConnected(this@MainActivity)) {
                "Service: CONNECTED"
            } else {
                "Service: NOT CONNECTED"
            }
            textSize = 20f
            gravity = Gravity.CENTER
        }

        val lastEvent = TextView(this).apply {
            text = "Last event:\n${ServiceState.lastEvent(this@MainActivity)}"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 30, 0, 30)
        }

        val settingsButton = Button(this).apply {
            text = "OPEN ACCESSIBILITY SETTINGS"

            setOnClickListener {
                startActivity(
                    Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                )
            }
        }

        val infoButton = Button(this).apply {
            text = "APP INFO"

            setOnClickListener {
                startActivity(
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        android.net.Uri.parse("package:$packageName")
                    )
                )
            }
        }

        val diagnostic = TextView(this).apply {
            text = "Diagnostic mode only.\nNo automatic ride acceptance is active yet."
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 30, 0, 0)
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(status)
        root.addView(lastEvent)
        root.addView(settingsButton)
        root.addView(infoButton)
        root.addView(diagnostic)

        setContentView(root)
    }

    override fun onResume() {
        super.onResume()
        recreate()
    }
}
