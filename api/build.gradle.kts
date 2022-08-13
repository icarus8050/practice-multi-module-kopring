tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":order"))
    implementation(project(":infrastructure"))

    testImplementation("io.rest-assured:kotlin-extensions:4.3.3")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.rest-assured:spring-mock-mvc:4.3.3") // 버전을 지정안하면 3.3.0을 사용하면서 ClassNotFound 에러 발생
    testImplementation("io.rest-assured:spring-mock-mvc-kotlin-extensions:4.3.3") // 버전을 지정안하면 3.3.0을 사용하면서 ClassNotFound 에러 발생
}
