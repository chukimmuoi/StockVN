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
rootProject.name = "StockVN"
include(":app")
include(":data")
include(":domain")
include(":macrobenchmark")
include(":feature")
include(":sync")
include(":lint")
include(":core:designsystem")
include(":core:model")
include(":sync:work")
