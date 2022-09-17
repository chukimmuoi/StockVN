plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        // The schemas directory contains a schema file for each version of the Room database.
        // This is required to enable Room auto migrations.
        // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.Google.Android.material)

    testImplementation(Libs.Junit.junit)

    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.espressoCore)

    api(Libs.Google.gson)

    api(Libs.AndroidX.Room.roomRuntime)
    kapt(Libs.AndroidX.Room.roomCompiler)
    api(Libs.AndroidX.Room.roomKtx)
    api(Libs.AndroidX.Room.roomPaging)

    api(Libs.AndroidX.Paging.pagingRuntime)
    api(Libs.AndroidX.Paging.pagingCompose)

    api(Libs.SquareUp.Retrofit2.retrofit)
    api(Libs.SquareUp.Retrofit2.converterGson)
    api(Libs.SquareUp.Okhttp3.loggingInterceptor)

    api(Libs.SquareUp.JakeWharton.timber)
}