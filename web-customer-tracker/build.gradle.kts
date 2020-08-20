import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.scripting") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    war
}

group = "com.thijsboehme"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.3.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.3.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.0")
    implementation("mysql:mysql-connector-java:8.0.21")
    implementation("javax:javaee-api:7.0")
    implementation("com.mchange:c3p0:0.9.5.5")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
