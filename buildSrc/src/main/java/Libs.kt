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

            const val version = "1.1.0-beta01"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"

            const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
        }

        object Activity {

            private const val activity = "1.3.1"
            const val activityCompose = "androidx.activity:activity-compose:$activity"
        }


        object Lifecycle {

            private const val version = "2.3.1"
            const val runtimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
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
    }

    object Google {

        object Android {

            private const val version = "1.6.1"
            const val material = "com.google.android.material:material:$version"
        }

        private const val gsonVersion = "2.9.1"
        const val gson = "com.google.code.gson:gson:$gsonVersion"
    }

    object Junit {

        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }
}