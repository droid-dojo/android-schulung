plugins {
    alias(libs.plugins.samples.android.application)
    alias(libs.plugins.samples.android.application.compose)
}

android {
    namespace = "ninja.droiddojo.samples.architecture.coroutines"

    defaultConfig {
        applicationId = "ninja.droiddojo.samples.architecture.coroutines"
        versionCode = 1
        versionName = "0.0.1"
    }
}

dependencies {
    implementation(projects.architecture.shared)
}