plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Android.compileSdk)
    buildToolsVersion(Android.toolsVersion)

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.shvants.balinatestapp"
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = versionCode
        versionName = versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        java {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(Projects.database))
    implementation(project(Projects.network))

    implementation(Libs.appCompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.coreKtx)
    implementation(Libs.koin)
    implementation(Libs.koinExt)
    implementation(Libs.material)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.viewBinding)
}