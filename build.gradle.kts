plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.allopen") version "1.8.21"
    kotlin("plugin.jpa") version "1.8.21"
    kotlin("plugin.serialization") version "1.8.21"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    // BOM
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:quarkus-google-cloud-services-bom:${quarkusPlatformVersion}"))

    // Templates
    implementation("io.quarkus:quarkus-qute")

    // Database
    implementation("io.quarkus:quarkus-flyway")
    implementation("io.quarkus:quarkus-jdbc-postgresql")

    // Storage
    implementation("io.quarkiverse.googlecloudservices:quarkus-google-cloud-storage")
    implementation("com.google.cloud.sql:postgres-socket-factory:1.12.0")

    // Config
    implementation("io.quarkus:quarkus-config-yaml")

    // Kotlin
    implementation("io.quarkus:quarkus-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Build
    implementation("io.quarkus:quarkus-arc")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs += "-Xjvm-default=all"
}