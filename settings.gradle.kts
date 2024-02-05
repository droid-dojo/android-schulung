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

include(":kotlin:classes")
include(":kotlin:classes-solution")
include(":kotlin:conditions")
include(":kotlin:conditions-solution")
include(":kotlin:functions")
include(":kotlin:functions-solution")
include(":kotlin:loops")
include(":kotlin:loops-solution")
include(":kotlin:variables")
include(":kotlin:variables-solution")
include(":compose:basics")
include(":compose:basics-solution")

