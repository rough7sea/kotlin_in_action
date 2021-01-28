import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    application
}
group = "com.roughsea"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}


dependencies {
    implementation("com.beust:klaxon:5.0.1")
    implementation("junit:junit:4.12")
    testImplementation(
        "org.assertj:assertj-core:3.12.2",
        "org.junit.jupiter:junit-jupiter-api:5.4.2"
    )
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}