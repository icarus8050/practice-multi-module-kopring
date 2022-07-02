plugins {
    kotlin("plugin.jpa") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.zaxxer:HikariCP")
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":order"))
}
