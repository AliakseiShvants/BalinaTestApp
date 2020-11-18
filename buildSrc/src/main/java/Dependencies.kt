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

object Libs {
    const val androidBuildTools = "com.android.tools.build:gradle:${Version.androidBuildTools}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"

    const val coil = "io.coil-kt:coil:${Version.coil}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"

    const val googlePlayLocation =
        "com.google.android.gms:play-services-location:${Version.googlePlay}"
    const val googlePlayMaps =
        "com.google.android.gms:play-services-maps:${Version.googlePlay}"

    const val koin = "org.koin:koin-androidx-scope:${Version.koin}"
    const val koinExt = "org.koin:koin-androidx-ext:${Version.koin}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"

    const val material = "com.google.android.material:material:${Version.material}"

    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

    const val okHttpLogInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.okHttpLogInterceptor}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"

    const val viewBinding =
        "com.kirich1409.viewbindingpropertydelegate:viewbindingpropertydelegate:${Version.viewBindingDelegates}"
}

object Projects {
    const val database = ":database"
    const val network = ":network"
}

object Version {
    const val androidBuildTools = "4.0.1"
    const val appCompat = "1.1.0"

    const val coil = "1.0.0"
    const val constraintLayout = "2.0.1"
    const val coreKtx = "1.3.1"

    const val googlePlay = "17.0.0"

    const val koin = "2.1.6"
    const val kotlin = "1.4.10"

    const val material = "1.2.0"
    const val navigation = "2.3.0"

    const val okHttpLogInterceptor = "3.9.0"

    const val retrofit = "2.9.0"
    const val room = "2.2.5"

    const val viewBindingDelegates = "1.3.0"
}
