plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Android.compileSdk)
}

dependencies {
    implementation(Libs.koin)
    implementation(Libs.koinExt)
    implementation(Libs.roomKtx)
    implementation(Libs.roomRuntime)
    kapt(Libs.roomCompiler)
}