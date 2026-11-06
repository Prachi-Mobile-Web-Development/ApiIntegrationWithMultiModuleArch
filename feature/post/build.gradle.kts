plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt.android)

    alias(libs.plugins.ksp.android)
    id("org.jetbrains.kotlin.plugin.compose")

}

android {
    namespace = "com.example.feature.post"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(project(":domain"))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation (libs.android.hilt)
    ksp (libs.android.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

}