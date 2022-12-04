buildscript {
    dependencies {

    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Libs.androidApplication) version(Versions.android) apply(false)
    id(Libs.androidLibrary) version(Versions.android) apply(false)
    //id(Libs.androidTest) version(Versions.android) apply false
    id(Libs.kotlinAndroid) version(Versions.kotlin) apply(false)
    id(Libs.Google.Dagger.hiltAndroidGradlePlugin) version(Libs.Google.Dagger.version) apply(false)
    id(Libs.Google.Gms.googleServices) version(Libs.Google.Gms.version) apply(false)
    id(Libs.kotlinJVM) version(Versions.kotlin) apply(false)
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}