import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    `maven-publish`
    signing
}

// cleanup
ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKeyRingFile"] = null
ext["sonatypeUsername"] = null
ext["sonatypePassword"] = null

val secretPropsFile: File = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach { (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["sonatypeUsername"] = System.getenv("SONATYPE_USERNAME")
    ext["sonatypePassword"] = System.getenv("SONATYPE_PASSWORD")
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

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
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

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            val url = if (version.toString().contains("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            setUrl(url)
            credentials {
                username = project.ext["sonatypeUsername"]?.toString()
                password = project.ext["sonatypePassword"]?.toString()
            }
        }

        publications {
            create<MavenPublication>("binaryAndSources") {
                from(components["java"])
            }
        }
    }

    // Configure all publications
    publications.withType<MavenPublication> {
        // Provide artifacts information requited by Maven Central
        pom {
            name.set("Setsuna")
            description.set("A Twitter API v2.0 implementation in Kotlin/JVM")
            url.set("https://github.com/StarWishsama/Setsuna")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://github.com/StarWishsama/Setsuna/blob/master/LICENSE")
                }
            }
            developers {
                developer {
                    id.set("NoRainCity")
                    email.set("starwishsama@outlook.com")
                }
            }
            scm {
                url.set("https://github.com/StarWishsama/Setsuna")
                connection.set("scm:git:git://github.com/StarWishsama/Setsuna.git")
                developerConnection.set("scm:git:ssh://git@github.com/StarWishsama/Setsuna.git")
            }
        }
    }
}

signing {
    sign(publishing.publications)
}