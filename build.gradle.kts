buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.androidBuildTools)
        classpath(Libs.koin)
        classpath(Libs.kotlinGradle)
        classpath(Libs.navigation)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
//        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}