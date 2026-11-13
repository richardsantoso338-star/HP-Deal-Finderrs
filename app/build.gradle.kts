plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "id.hpdealfinder"
    compileSdk = 35
    defaultConfig {
        applicationId = "id.hpdealfinder"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }
}
