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
include(":compose:image-loading")
include(":compose:image-loading-solution")
include(":compose:lists")
include(":compose:lists-solution")
include(":compose:navigation")
include(":compose:navigation-solution")
include(":compose:resources")
include(":compose:resources-solution")
include(":compose:state-hoisting")
include(":compose:state-hoisting-solution")
include(":compose:states")
include(":compose:states-solution")
include(":architecture:coroutines")
include(":architecture:coroutines-solution")
include(":architecture:viewmodels")
include(":architecture:viewmodels-solution")
include(":architecture:state-flow")
include(":architecture:state-flow-solution")



