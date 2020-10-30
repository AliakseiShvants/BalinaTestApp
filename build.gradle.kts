buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.androidBuildTools)
        classpath(Libs.koin)
        classpath(Libs.kotlinGradle)
        classpath(Libs.navigation)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}