plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ridefast.autoaccept"

    compileSdk = 36

    defaultConfig {
        applicationId = "com.ridefast.autoaccept"

        minSdk = 26
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"
    }

    kotlin {
        jvmToolchain(17)
    }
}
