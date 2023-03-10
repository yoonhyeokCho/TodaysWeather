plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.example.todaysweather.navigator"
}

dependencies {
    implementation(project(":shared"))

    // Android Core
    implementation(AndroidXDependencies.coreKtx)

    // test
    implementation(AndroidXDependencies.junit)
    androidTestImplementation(TestDependencies.androidTest)
}