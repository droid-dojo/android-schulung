plugins {
    alias(libs.plugins.samples.android.application)
    alias(libs.plugins.samples.android.application.compose)
}

android {
    namespace = "ninja.droiddojo.samples.architecture.viewmodels"

    defaultConfig {
        applicationId = "ninja.droiddojo.samples.architecture.viewmodels"
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
    implementation(libs.androidx.navigation.compose)

    implementation(libs.coil.kt.compose)

    implementation(libs.androidx.lifecycle.viewModelCompose)

    debugImplementation(libs.androidx.compose.ui.tooling)
}