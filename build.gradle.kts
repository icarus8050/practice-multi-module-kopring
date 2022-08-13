import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("kapt") version "1.6.10"
}

allprojects {
    repositories {
        mavenCentral()
    }

    group = "com.example"
    version = "1.0-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-spring")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot")
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }

        testImplementation("io.mockk:mockk:1.12.5")
    }
}
