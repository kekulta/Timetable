plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.kekulta.timetable"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.kekulta.timetable"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
}

dependencies {
    /**
     * Room Database
     */
    implementation("androidx.room:room-runtime:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")
    implementation("androidx.room:room-rxjava2:2.5.2")

    /**
     * ViewBinding delegate
     */
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9")

    /**
     * ViewModels
     */
    implementation("androidx.activity:activity-ktx:1.7.2")

    /**
     * Dagger DI
     */
    implementation("com.google.dagger:dagger:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")

    /**
     * Retrofit
     */
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    /**
     * RxJava
     */
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")

    /**
     * Kotlin extensions for 'core' artifact
     */
    implementation("androidx.core:core-ktx:1.10.1")

    /**
     * Provides backwards-compatible implementations of UI-related Android SDK functionality
     */
    implementation("androidx.appcompat:appcompat:1.6.1")

    /**
     * Material Design
     */
    implementation("com.google.android.material:material:1.9.0")

    /**
     * ConstraintLayout
     */
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    /**
     * FlexBoxLayout
     */
    implementation("com.google.android.flexbox:flexbox:3.0.0")

}