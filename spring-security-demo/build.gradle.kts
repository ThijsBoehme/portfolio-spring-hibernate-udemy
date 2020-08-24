import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.0"
    id("org.jetbrains.kotlin.plugin.scripting") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    `maven-publish`
    war
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework:spring-webmvc")
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
    implementation("javax.servlet:javax.servlet-api:3.1.0")
    implementation("javax.servlet.jsp:javax.servlet.jsp-api:2.3.1")
    implementation("javax.servlet:jstl:1.2")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    testImplementation("junit:junit:3.8.1")
}

group = "com.luv2code"
version = "1.0"
description = "spring-security-demo"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
