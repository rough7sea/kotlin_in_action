import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    application
}
val kotlinVersion = "1.4.21"
val exposedVersion = "0.29.1"
group = "com.roughsea"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}


dependencies {

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
//    implementation("org.jetbrains.kotlinx:kotlinx-html-js:${kotlinxHtmlVersion}")

    implementation("com.beust:klaxon:5.0.1")
    implementation("junit:junit:4.12")
    implementation("com.github.yole:jkid:ec66c0b13c")
    testImplementation(
        "org.assertj:assertj-core:3.12.2"
//        ,
//        "org.junit.jupiter:junit-jupiter-api:5.4.2"
    )
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.1.9")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}