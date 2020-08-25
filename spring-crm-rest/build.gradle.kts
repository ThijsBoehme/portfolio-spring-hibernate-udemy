plugins {
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
    kotlin("plugin.jpa") version "1.4.0"
    id("org.springframework.boot") version "2.3.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    war
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.springframework:spring-webmvc")
    implementation("org.springframework:spring-tx")
    implementation("org.springframework:spring-orm")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")
    implementation("org.hibernate:hibernate-core")
    implementation("mysql:mysql-connector-java")
    implementation("com.mchange:c3p0:0.9.5.2")
    implementation("javax.servlet:javax.servlet-api")
    implementation("javax.servlet.jsp:javax.servlet.jsp-api:2.3.3")
    implementation("javax.xml.bind:jaxb-api")
}

group = "com.thijsboehme.springdemo"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11 
