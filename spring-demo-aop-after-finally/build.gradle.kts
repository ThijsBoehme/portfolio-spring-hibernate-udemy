import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.scripting") version "1.3.72"
	war
}

group = "com.thijsboehme"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.3.RELEASE")
	implementation("mysql:mysql-connector-java:8.0.21")
	implementation("javax:javaee-api:8.0.1")
	implementation("com.mchange:c3p0:0.9.5.5")
	implementation("javax.servlet:jstl:1.2")
	implementation("org.aspectj:aspectjweaver:1.9.6")
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

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}
