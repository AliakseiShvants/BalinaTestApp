buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(GradlePlugin.androidBuildTools)
//        classpath(GradlePlugin.koin)
        classpath(GradlePlugin.kotlinGradle)
        classpath(GradlePlugin.navigation)
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