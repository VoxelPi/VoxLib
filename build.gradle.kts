import net.kyori.indra.IndraPlugin
import net.kyori.indra.IndraPublishingPlugin
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.shadow) apply false
    alias(libs.plugins.indra)
    alias(libs.plugins.indra.git)
    alias(libs.plugins.indra.publishing) apply false
    alias(libs.plugins.blossom) apply false
}

allprojects {
    group = "net.voxelpi.voxlib"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        mavenLocal()
    }
}

subprojects {
    apply<KotlinPluginWrapper>()
    apply<DokkaPlugin>()
    apply<IndraPlugin>()
    apply<IndraPublishingPlugin>()


    tasks {
        val javaVersion = JavaVersion.VERSION_17

        dokkaHtml.configure {
            outputDirectory.set(layout.buildDirectory.dir("docs"))
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
                            url.set("https://voxelpi.dev")
                        }
                    }
                }
            }
        }
    }
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(layout.buildDirectory.dir("docs"))
}
