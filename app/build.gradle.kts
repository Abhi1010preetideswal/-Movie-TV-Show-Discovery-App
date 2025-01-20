plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization") version "1.8.22" // Ensure Kotlin plugin is included
}

android {
    namespace = "com.example.movietv"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.movietv"
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.runtime.livedata)
//    implementation(libs.androidx.runtime.livedata)

<<<<<<< HEAD
    // Testing
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
//    testImplementation(libs.junit)
        // JUnit for unit tests
        testImplementation("junit:junit:4.13.2")

        // Mockito for mocking
        testImplementation("org.mockito:mockito-core:4.11.0")

        // Coroutines testing
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

        // LiveData and ViewModel testing
        testImplementation("androidx.arch.core:core-testing:2.1.0")


=======
    // Testing 
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation(libs.junit)
>>>>>>> f2c204a5e26abb2214abed0883de0db988893b5b
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

     
   // testImplementation("io.mockk:mockk:1.12.0")
 


    // Directly declared dependencies
    // Compose
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.activity:activity-compose:1.7.2")

    implementation("androidx.compose.material:material:1.7.6")
    implementation("androidx.compose.ui:ui:1.7.6")
    implementation("androidx.compose.ui:ui-tooling:1.7.6")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

    // RxJava
    implementation("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")

    // Dependency Injection
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("io.insert-koin:koin-android:3.4.0")
    implementation("io.insert-koin:koin-androidx-compose:3.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

}
