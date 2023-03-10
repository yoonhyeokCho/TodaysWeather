pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TodaysWeather"
include(":app")
include(":domain")
include(":feature")
include(":data")
include(":shared")
include(":core-ui")
include(":navigator")
