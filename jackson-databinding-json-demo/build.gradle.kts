//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")
}

group = "com.thijsboehme"
version = "1.0.0"
description = "jackson-demo"
java.sourceCompatibility = JavaVersion.VERSION_11
