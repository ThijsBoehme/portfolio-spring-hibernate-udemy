import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
    kotlin("plugin.jpa") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "com.thijsboehme.springboot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Other
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
