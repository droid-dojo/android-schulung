plugins {
    alias(libs.plugins.samples.android.application)
    alias(libs.plugins.samples.android.application.compose)
    alias(libs.plugins.samples.hilt)
    alias(libs.plugins.samples.android.room)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ninja.droiddojo.samples.apps.rick"

    defaultConfig {
        applicationId = "ninja.droiddojo.samples.apps.rick"
        versionCode = 1
        versionName = "0.0.1"
    }
}

dependencies {
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.ext.work)

    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.network.okhttp)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.work.ktx)

    debugImplementation(libs.androidx.compose.ui.tooling)
}