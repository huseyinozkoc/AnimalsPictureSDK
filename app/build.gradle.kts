plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.5.30" apply true
}

android {
    namespace = "com.superapp.catanddogsdk"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.superapp.catanddogsdk"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    defaultConfig {
        multiDexEnabled = true
    }


}

dependencies {

    implementation(project(":CatDogSDK"))
    implementation("androidx.multidex:multidex:2.0.1")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.analytics)
    implementation("org.jetbrains:annotations:15.0")
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    //Room
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Coroutine Lifecycle Scopes
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    //Coil
    implementation(libs.coil.compose)

    // WorkManager (Kotlin + Coroutines)
    implementation(libs.androidx.work.runtime.ktx)

    //Data Storage
    implementation(libs.androidx.datastore.preferences)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v241)

    //Lottie
    implementation(libs.lottie.compose)

    // Import the BoM for the Firebase platform
    implementation(platform(libs.firebase.bom))

    //Firebase( For Authentication and Firestore )
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    // Firebase Analytics
    implementation(libs.firebase.analytics)

    // Firebase Crashlytics
    implementation(libs.firebase.crashlytics)

    // Firebase Performance Monitoring
    implementation(libs.firebase.perf.ktx)

    // DataStore
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.core)
    implementation(libs.protobuf.javalite)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)
    //Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")

    //Lottie
    implementation(libs.lottie.compose)

    implementation (libs.kotlinx.serialization.json)
}