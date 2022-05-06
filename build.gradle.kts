import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.6.20"
val publishingToken = System.getenv("PUBLISH_TOKEN")

group = "co.anbora.labs"
version = "2022.1.3"

plugins {
    id("java")
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.intellij") version "1.5.3"
    id("org.jetbrains.grammarkit") version "2021.2.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testImplementation("junit:junit:4.13.2")
}

apply {
    plugin("kotlin")
    plugin("org.jetbrains.grammarkit")
    plugin("org.jetbrains.intellij")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("LATEST-EAP-SNAPSHOT")
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

sourceSets {
    main {
        java.srcDirs("src/main/gen")
    }
}

tasks {

    patchPluginXml {
        sinceBuild.set("203")
        changeNotes.set(file("src/main/html/change-notes.html").inputStream().readBytes().toString(Charsets.UTF_8))
        pluginDescription.set(file("src/main/html/description.html").inputStream().readBytes().toString(Charsets.UTF_8))
    }

    generateLexer {
        source.set("src/main/grammar/FirebaseRules.flex")
        targetDir.set("src/main/gen/co/anbora/labs/firebase/lang/")
        targetClass.set("FirebaseRulesLexer")
        purgeOldFiles.set(true)
    }

    generateParser {
        source.set("src/main/grammar/FirebaseRules.bnf")
        targetRoot.set("src/main/gen")
        pathToParser.set("/co/anbora/labs/firebase/lang/core/parser/FirebaseRulesParser.java")
        pathToPsiRoot.set("/co/anbora/labs/firebase/lang/core/psi")
        purgeOldFiles.set(true)
    }

    withType<KotlinCompile> {
        dependsOn(generateLexer, generateParser)
        kotlinOptions {
            jvmTarget = "11"
            languageVersion = "1.6"
            apiVersion = "1.6"
            freeCompilerArgs = listOf("-Xjvm-default=all")
        }
    }

    publishPlugin {
        token.set(publishingToken)
    }
}
