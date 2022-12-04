plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.chukimmuoi.core.designsystem"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.versionUse
    }
    
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(Libs.AndroidX.coreKtx)

    api(Libs.AndroidX.appcompat)
    api(Libs.Google.Android.material)
    testApi(Libs.Junit.junit)
    androidTestApi(Libs.AndroidX.Test.Ext.junit)
    androidTestApi(Libs.AndroidX.Test.Espresso.espressoCore)

    androidTestApi(Libs.AndroidX.Compose.uiTestJunit4)
    debugApi(Libs.AndroidX.Compose.uiTestManifest)

    api(platform(Libs.AndroidX.Compose.composeBOM))
    api(Libs.AndroidX.Compose.ui)
    api(Libs.AndroidX.Compose.uiToolingPreview)
    debugApi(Libs.AndroidX.Compose.uiTooling)

    api(Libs.AndroidX.Compose.Material3.material3)
    api(Libs.AndroidX.Compose.materialIconExtended)
}