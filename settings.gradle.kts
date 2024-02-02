pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "exercises"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":kotlin:classes")
include(":kotlin:conditions")
include(":kotlin:functions")
include(":kotlin:loops")
include(":kotlin:variables")
