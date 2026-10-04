package com.ridefast.autoaccept

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this).apply {
            text = "RideFast Auto Accept"
            textSize = 24f
            setPadding(40, 40, 40, 40)
        }

        setContentView(textView)
    }
}
