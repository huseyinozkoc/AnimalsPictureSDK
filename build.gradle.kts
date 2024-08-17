// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false

    //Hilt
    id("com.google.dagger.hilt.android") version "2.48" apply false

    id ("org.jetbrains.kotlin.plugin.serialization") version "1.5.30" apply true
}