plugins {
    alias(libs.plugins.samples.android.application)
    alias(libs.plugins.samples.android.application.compose)
}

android {
    defaultConfig {
        applicationId = "ninja.droiddojo.samples.compose.images"
        versionCode = 1
        versionName = "0.0.1"
    }

    namespace = "ninja.droiddojo.samples.compose.images"
}

dependencies {
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.network.okhttp)

    debugImplementation(libs.androidx.compose.ui.tooling)
}