// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

    // Safe Args Eklentisi: Ekranlar arası veri (argüman) gönderirken tip güvenliği (type-safety) sağlar.
    // "apply false" ile kök projede sadece tanımlanır, ihtiyaç duyulan modüllerde aktif edilir.
    id("androidx.navigation.safeargs.kotlin") version "2.10.2" apply false

}