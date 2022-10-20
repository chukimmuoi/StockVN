/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 27/08/2022.
 */
object Libs {
    // Setting
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"

    object Coroutines {

        private const val version = "1.6.4"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    // Default libs support.
    object AndroidX {

        private const val coreKtxVersion = "1.7.0"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

        private const val appcompatVersion =  "1.5.0"
        const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"

        object Compose {

            const val version = "1.2.0-beta02"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconExtended = "androidx.compose.material:material-icons-extended:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"

            const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"

            object Material3 {
                // https://developer.android.com/jetpack/androidx/releases/compose-material3
                private const val version = "1.0.0-beta03"

                const val material3 = "androidx.compose.material3:material3:$version"
            }
        }

        object Activity {

            private const val activity = "1.3.1"
            const val activityCompose = "androidx.activity:activity-compose:$activity"
        }


        object Lifecycle {
            // https://developer.android.com/jetpack/androidx/releases/lifecycle
            private const val version = "2.5.1"

            // ViewModel
            const val viewModelKTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            // ViewModel utilities for Compose
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            // LiveData
            const val liveDataKTX = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            // Lifecycles only (without ViewModel or LiveData)
            const val runtimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Room {
            // https://developer.android.com/jetpack/androidx/releases/room

            private const val version = "2.4.3"
            const val roomRuntime = "androidx.room:room-runtime:$version"
            const val roomCompiler = "androidx.room:room-compiler:$version"
            const val roomKtx = "androidx.room:room-ktx:$version"

            private const val pagingVersion = "2.5.0-alpha03"
            const val roomPaging = "androidx.room:room-paging:$version"
        }

        object Test {
            object Ext {
                private const val version = "1.1.3"
                const val junit = "androidx.test.ext:junit:$version"
            }

            object Espresso {
                private const val version = "3.4.0"
                const val espressoCore = "androidx.test.espresso:espresso-core:$version"
            }
        }

        object Paging {
            private const val version = "3.1.1"
            private const val versionCompose = "1.0.0-alpha16"

            const val pagingRuntime = "androidx.paging:paging-runtime:$version"
            const val pagingCompose = "androidx.paging:paging-compose:$versionCompose"
        }

        object Navigation {
            private const val version = "2.5.2"

            const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            const val navigationCompose = "androidx.navigation:navigation-compose:$version"

        }

        object Work {
            private const val version = "2.7.1"

            const val workRuntime = "androidx.work:work-runtime:$version"
            const val workRuntimeKtx = "androidx.work:work-runtime-ktx:$version"


        }
    }

    object Google {

        object Android {

            private const val version = "1.6.1"
            const val material = "com.google.android.material:material:$version"
        }

        // https://github.com/google/gson
        private const val gsonVersion = "2.9.1"
        const val gson = "com.google.code.gson:gson:$gsonVersion"

        object Dagger {
            // https://developer.android.com/training/dependency-injection/hilt-android#kts
            // https://dagger.dev/hilt/gradle-setup
            const val version = "2.43.2"

            const val hiltAndroidGradlePlugin = "com.google.dagger.hilt.android"
            const val hiltAndroid = "com.google.dagger:hilt-android:$version"
            const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        }

        object Gms {
            const val version = "4.3.13"

            const val googleServices = "com.google.gms.google-services"
        }

        object Firebase {
            private const val version = "31.0.0"

            // Import the Firebase BoM
            const val fireBaseBOM = "com.google.firebase:firebase-bom:$version"

            // TODO: Add the dependencies for Firebase products you want to use
            // When using the BoM, don't specify versions in Firebase dependencies
            const val fireAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"

            // Add the dependencies for any other desired Firebase products
            // https://firebase.google.com/docs/android/setup#available-libraries
        }
    }

    object Junit {

        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object SquareUp {
        object Retrofit2 {
            // https://square.github.io/retrofit/
            // https://github.com/square/retrofit
            private const val version = "2.9.0"

            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        }

        object Okhttp3 {
            private const val version = "4.10.0"

            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object JakeWharton {
            private const val version = "5.0.1"

            const val timber = "com.jakewharton.timber:timber:$version"
        }
    }
}

//object Libs {
//    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
//    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:1.1.5"
//
//    const val junit = "junit:junit:4.13"
//
//    const val material3 = "com.google.android.material:material:1.5.0-alpha05"
//
//    object Accompanist {
//        const val version = "0.21.4-beta"
//        const val insets = "com.google.accompanist:accompanist-insets:$version"
//    }
//
//    object Kotlin {
//        private const val version = "1.6.0"
//        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
//        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
//        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
//    }
//
//    object Coroutines {
//        private const val version = "1.5.2"
//        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
//        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
//        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
//    }
//
//    object AndroidX {
//        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
//        const val coreKtx = "androidx.core:core-ktx:1.7.0"
//
//        object Activity {
//            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
//        }
//
//        object Compose {
//            const val snapshot = ""
//            const val version = "1.1.0-beta04"
//
//            const val foundation = "androidx.compose.foundation:foundation:$version"
//            const val layout = "androidx.compose.foundation:foundation-layout:$version"
//            const val material = "androidx.compose.material:material:$version"
//            const val runtime = "androidx.compose.runtime:runtime:$version"
//            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
//            const val tooling = "androidx.compose.ui:ui-tooling:$version"
//            const val test = "androidx.compose.ui:ui-test:$version"
//            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
//            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
//            const val uiUtil = "androidx.compose.ui:ui-util:${version}"
//
//            object Material3 {
//                const val snapshot = ""
//                const val version = "1.0.0-alpha01"
//
//                const val material3 = "androidx.compose.material3:material3:$version"
//            }
//        }
//
//        object Navigation {
//            private const val version = "2.3.5"
//            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
//            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
//        }
//
//        object Test {
//            private const val version = "1.4.0"
//            const val core = "androidx.test:core:$version"
//            const val rules = "androidx.test:rules:$version"
//
//            object Ext {
//                private const val version = "1.1.2"
//                const val junit = "androidx.test.ext:junit-ktx:$version"
//            }
//
//            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
//        }
//
//        object Lifecycle {
//            private const val version = "2.4.0"
//            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
//            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
//            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
//        }
//    }
//}