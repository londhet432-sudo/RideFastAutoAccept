package com.ridefast.autoaccept

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class RideAutoAcceptService : AccessibilityService() {

    companion object {
        private const val TAG = "RideFastService"
    }

    override fun onServiceConnected() {
        super.onServiceConnected()

        Log.d(TAG, "SERVICE CONNECTED")

        // Diagnostic only.
        // No ride detection or automatic clicking yet.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

        if (event == null) {
            return
        }

        Log.d(
            TAG,
            "EVENT: type=${event.eventType}, package=${event.packageName}"
        )
    }

    override fun onInterrupt() {
        Log.d(TAG, "SERVICE INTERRUPTED")
    }

    override fun onDestroy() {
        Log.d(TAG, "SERVICE DESTROYED")
        super.onDestroy()
    }
}
