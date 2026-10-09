plugins {
    alias(libs.plugins.android.application)
    id("androidx.navigation.safeargs.kotlin") // verileri ekranlar (fragment'lar) arasında güvenli (type-safe) ve hatasız tasşır

}

android {
    namespace = "com.example.syncflow"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.syncflow"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Android Navigation Kütüphanesi
    // navigation-fragment-ktx: Fragment'lar arası geçişleri ve yönlendirmeleri yönetir.
    // navigation-ui-ktx: Üst menü, alt menü (Bottom Nav) gibi UI bileşenlerini navigation ile bağlar.

    val nav_version = "2.10.2"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

}
