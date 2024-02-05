plugins {
    alias(libs.plugins.samples.android.library)
    alias(libs.plugins.samples.android.library.compose)
}

android {
    namespace = "ninja.droiddojo.samples.compose.basics"
}

dependencies {
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling.preview)

    debugImplementation(libs.androidx.compose.ui.tooling)
}