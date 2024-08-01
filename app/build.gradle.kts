////plugins {
////    alias(libs.plugins.android.application)
////    alias(libs.plugins.jetbrains.kotlin.android)
////    kotlin("kapt")
////    id("dagger.hilt.android.plugin")
////}
////
////android {
////    namespace = "com.kg.cryptocurrencytracker"
////    compileSdk = 34
////
////    defaultConfig {
////        applicationId = "com.kg.cryptocurrencytracker"
////        minSdk = 24
////        targetSdk = 34
////        versionCode = 1
////        versionName = "1.0"
////
////        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
////        vectorDrawables {
////            useSupportLibrary = true
////        }
////    }
////
////    buildTypes {
////        release {
////            isMinifyEnabled = false
////            proguardFiles(
////                getDefaultProguardFile("proguard-android-optimize.txt"),
////                "proguard-rules.pro"
////            )
////        }
////    }
////    compileOptions {
////        sourceCompatibility = JavaVersion.VERSION_1_8
////        targetCompatibility = JavaVersion.VERSION_1_8
////    }
////    kotlinOptions {
////        jvmTarget = "1.8"
////    }
////    buildFeatures {
////        compose = true
////    }
////    composeOptions {
////        kotlinCompilerExtensionVersion = "1.5.1"
////    }
////    packaging {
////        resources {
////            excludes += "/META-INF/{AL2.0,LGPL2.1}"
////        }
////    }
////}
////
////dependencies {
////
////    implementation(libs.androidx.core.ktx)
////    implementation(libs.androidx.lifecycle.runtime.ktx)
////    implementation(libs.androidx.activity.compose)
////    implementation(platform(libs.androidx.compose.bom))
////    implementation(libs.androidx.ui)
////    implementation(libs.androidx.ui.graphics)
////    implementation(libs.androidx.ui.tooling.preview)
////    implementation(libs.androidx.material3)
////    testImplementation(libs.junit)
////    androidTestImplementation(libs.androidx.junit)
////    androidTestImplementation(libs.androidx.espresso.core)
////    androidTestImplementation(platform(libs.androidx.compose.bom))
////    androidTestImplementation(libs.androidx.ui.test.junit4)
////    debugImplementation(libs.androidx.ui.tooling)
////    debugImplementation(libs.androidx.ui.test.manifest)
////    // compose
////    val compose_version = "1.0.5"
////    val activity_compose_version = "1.3.1"
////    implementation("androidx.compose.ui:ui:$compose_version")
////    implementation("androidx.compose.material:material:$compose_version")
////    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
////    implementation("androidx.activity:activity-compose:$activity_compose_version")
////    // import retrofit
////    // Retrofit
////    implementation("com.squareup.retrofit2:retrofit:2.9.0")
////    // Gson converter for Retrofit
////    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
////
////    //Dagger - Hilt
////    implementation("com.google.dagger:hilt-android:2.38.1")
////    kapt("com.google.dagger:hilt-android-compiler:2.37")
////    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03") // Corrected line
////    kapt("androidx.hilt:hilt-compiler:1.0.0")
////    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03") // Corrected line
////}
//plugins {
//    id("com.android.application")
//    id("kotlin-android")
//    id("kotlin-kapt")
//    id("dagger.hilt.android.plugin")
//}
//
//android {
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.plcoding.cryptocurrencyappyt"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary = true
//        }
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = compose_version
//    }
//    packagingOptions {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//}
//
//val compose_version = "1.0.5"
//val activity_compose_version = "1.3.1"
//
//dependencies {
//    implementation("androidx.core:core-ktx:1.6.0")
//    implementation("androidx.appcompat:appcompat:1.3.1")
//    implementation("com.google.android.material:material:1.4.0")
//    implementation("androidx.compose.ui:ui:$compose_version")
//    implementation("androidx.compose.material:material:$compose_version")
//    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
//    implementation("androidx.activity:activity-compose:$activity_compose_version")
//    testImplementation("junit:junit:4.+")
//    androidTestImplementation("androidx.test.ext:junit:1.1.3")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
//    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
//
//    // Compose dependencies
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
//    implementation("androidx.navigation:navigation-compose:2.4.0-alpha08")
//    implementation("com.google.accompanist:accompanist-flowlayout:0.17.0")
//
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
//
//    // Coroutine Lifecycle Scopes
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
//
//    // Dagger - Hilt
//    implementation("com.google.dagger:hilt-android:2.38.1")
//    kapt("com.google.dagger:hilt-android-compiler:2.37")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    kapt("androidx.hilt:hilt-compiler:1.0.0")
//    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
//
//    // Retrofit
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
//    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
//}

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.kg.cryptocurrencytracker.CryptoCurrencyTracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kg.cryptocurrencytracker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.v1131)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Jetpack Compose
    implementation(libs.ui)
    implementation(libs.androidx.material)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.activity.compose.v161)
    implementation(libs.androidx.lifecycle.runtime.ktx.v284)
    implementation(libs.androidx.material3.android)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v121)
    androidTestImplementation(libs.androidx.espresso.core.v361)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)

    // Compose dependencies
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.flowlayout.v0300)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Coroutine Lifecycle Scopes
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v284)

    // Dagger - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    implementation(libs.kotlin.stdlib)
}
