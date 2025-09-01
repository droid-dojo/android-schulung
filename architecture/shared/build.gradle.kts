plugins {
    alias(libs.plugins.samples.android.library)
    alias(libs.plugins.samples.android.library.compose)
}

android {
    namespace = "ninja.droiddojo.samples.architecture.shared"
}

dependencies {
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)

    api(libs.androidx.lifecycle.viewModelCompose)

    api(libs.androidx.navigation.compose)

    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.network.okhttp)

    debugImplementation(libs.androidx.compose.ui.tooling)
}