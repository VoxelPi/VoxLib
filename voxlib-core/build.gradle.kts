plugins {
    `maven-publish`
    `java-library`
}

dependencies {
    api(kotlin("stdlib"))
    api(libs.kotlin.reflect)
    api(libs.bundles.kotlinx.coroutines)

    // Tests
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.jupiter.platform.launcher)
}

kotlin {
    jvmToolchain(17)
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}
