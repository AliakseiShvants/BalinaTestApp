object Android {
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29
    const val toolsVersion = "30.0.2"
}

object BuildVersion {
    const val versionCode = 1
    const val versionName = "1.0"
}

object GradlePlugin {
    const val androidBuildTools = "com.android.tools.build:gradle:${Version.androidBuildTools}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
//    const val koin = "org.koin:koin-gradle-plugin:${Version.koin}"
    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
}

object Libs {
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val material = "com.google.android.material:material:${Version.material}"
}

object Version {
    const val androidBuildTools = "4.0.1"
    const val appCompat = "1.1.0"

    const val constraintLayout = "2.0.1"
    const val coreKtx = "1.3.1"

    const val kotlin = "1.4.10"
    const val material = "1.2.0"
    const val navigation = "2.3.0"
}
