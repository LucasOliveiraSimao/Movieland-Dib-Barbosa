import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.google.gms.google.services)
}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties()
localProperties.load(FileInputStream(localPropertiesFile))

android {
    namespace = "com.lucassimao.movielanddibbarbosa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lucassimao.movielanddibbarbosa"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "API_TOKEN_TMDB", "\"${localProperties["API_TOKEN_TMDB"]}\"")
            buildConfigField("String", "BASE_URL_TMDB", "\"${localProperties["BASE_URL_TMDB"]}\"")
            buildConfigField("String", "API_TOKEN_NEWS", "\"${localProperties["API_TOKEN_NEWS"]}\"")
            buildConfigField("String", "BASE_URL_NEWS", "\"${localProperties["BASE_URL_NEWS"]}\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            buildConfigField("String", "API_TOKEN_TMDB", "\"${localProperties["API_TOKEN_TMDB"]}\"")
            buildConfigField("String", "BASE_URL_TMDB", "\"${localProperties["BASE_URL_TMDB"]}\"")
            buildConfigField("String", "API_TOKEN_NEWS", "\"${localProperties["API_TOKEN_NEWS"]}\"")
            buildConfigField("String", "BASE_URL_NEWS", "\"${localProperties["BASE_URL_NEWS"]}\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    implementation(libs.glide)

    implementation(libs.shimmer)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    implementation(libs.firebase.database)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}