// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlinSerialization) apply false
   // alias(libs.plugins.kspPlugin) version libs.versions.android.ksp apply false
    //alias(libs.plugins.hiltPlugin) version libs.versions.hilt apply false
}