plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.chukimmuoi.stockvn"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCodeMobile
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.materialIconExtended)
    implementation(Libs.AndroidX.Compose.uiToolingPreview)
    implementation(Libs.AndroidX.Lifecycle.runtimeKTX)
    implementation(Libs.AndroidX.Activity.activityCompose)

    testImplementation(Libs.Junit.junit)

    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.espressoCore)
    androidTestImplementation(Libs.AndroidX.Compose.uiTestJunit4)

    debugImplementation(Libs.AndroidX.Compose.uiTooling)
    debugImplementation(Libs.AndroidX.Compose.uiTestManifest)

    implementation(Libs.AndroidX.Lifecycle.liveDataKTX)
    implementation(Libs.AndroidX.Lifecycle.viewModelKTX)
    implementation(Libs.AndroidX.Lifecycle.viewModelCompose)

    implementation(Libs.Google.Dagger.hiltAndroid)
    kapt(Libs.Google.Dagger.hiltAndroidCompiler)
    implementation(Libs.Google.Dagger.hiltNavigationCompose)

    implementation(Libs.AndroidX.Navigation.navigationCompose)

    implementation(Libs.AndroidX.Work.workRuntime)
    implementation(Libs.AndroidX.Work.workRuntimeKtx)
}