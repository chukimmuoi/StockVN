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

    implementation(Libs.AndroidX.coreKtx)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    api(platform(Libs.AndroidX.Compose.composeBOM))
    api(Libs.AndroidX.Compose.ui)
    api(Libs.AndroidX.Compose.uiToolingPreview)
    debugApi(Libs.AndroidX.Compose.uiTooling)

    api(Libs.AndroidX.Compose.Material3.material3)
    api(Libs.AndroidX.Compose.materialIconExtended)
}