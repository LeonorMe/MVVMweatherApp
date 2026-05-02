// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("com.android.library") version "9.2.0" apply false
    id("org.jetbrains.kotlin.android") version "2.3.21" apply false
    id(lifecycle-viewmodel-compose) apply false
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.serialization") version "2.3.21"
}