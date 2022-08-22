import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

group = "ren.natsuyuk1.setsuna"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging-jvm:_")
    implementation("ch.qos.logback:logback-classic:_")

    implementation("org.jetbrains.kotlinx:atomicfu:_")

    implementation(KotlinX.serialization.json)
    implementation(KotlinX.datetime)

    implementation(Ktor.client.core)
    implementation(Ktor.client.cio)
    implementation(Ktor.client.encoding)
    implementation("io.ktor:ktor-client-content-negotiation:_")
    implementation("io.ktor:ktor-serialization-kotlinx-json:_")

    testImplementation(kotlin("test"))
}

sourceSets {
    main {
        java {
            setSrcDirs(setOf("kotlin"))
        }
    }
    test {
        java {
            setSrcDirs(setOf("kotlin"))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
