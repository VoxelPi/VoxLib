plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.dokka)
    alias(libs.plugins.indra)
    alias(libs.plugins.indra.git)
    alias(libs.plugins.indra.publishing)
    alias(libs.plugins.blossom)
    alias(libs.plugins.ktlint)
    `java-library`
}

group = "net.voxelpi.voxlib"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    mavenLocal()
}

dependencies {
    compileOnlyApi(kotlin("stdlib"))
    compileOnlyApi(libs.kotlin.reflect)
    compileOnlyApi(libs.bundles.kotlinx.coroutines)

    // Tests
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.jupiter.platform.launcher)
}

kotlin {
    jvmToolchain(21)
    explicitApi()
}

tasks {
    val javaVersion = JavaVersion.VERSION_21

    dokkaHtml.configure {
        outputDirectory.set(layout.buildDirectory.dir("docs"))
    }

    test {
        useJUnitPlatform()
    }

    ktlint {
        version.set("1.0.0")
        verbose.set(true)
        outputToConsole.set(true)
        coloredOutput.set(true)
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
    }

    indra {
        mitLicense()

        javaVersions {
            target(javaVersion.toString().toInt())
        }

        github("VoxelPi", "VoxLib") {
            ci(true)
            issues(true)
        }

        configurePublications {
            pom {
                developers {
                    developer {
                        id.set("voxelpi")
                        name.set("VoxelPi")
                        url.set("https://voxelpi.net")
                    }
                }
            }
        }
    }
}
