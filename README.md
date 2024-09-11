
Starting in Kotlin 2.0, the Compose Compiler Gradle plugin is required
when compose is enabled. See the following link for more information:
https://d.android.com/r/studio-ui/compose-compiler

&nbsp;1.  In your libs.versions.toml file, remove any reference to the Compose compiler
&nbsp;2.  In the plugins section, add the following new dependency
&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
&nbsp;3.  In your projects root build.gradle.kts file, add the following to the plugins section:
&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler) apply false
&nbsp;4.  In each module that uses Compose, apply the plugin:
&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler)

Dagger-Hilt
https://developer.android.com/training/dependency-injection/hilt-android

&nbsp;1.  In your libs.versions.toml file, in the plugins section, add the following new dependency
&nbsp;&nbsp;[versions]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltAndroid = "2.52"
&nbsp;&nbsp;[libraries]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltAndroid" }
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroid" }

&nbsp;2.  Add the hilt-android-gradle-plugin plugin to your project's root build.gradle.kts file:
&nbsp;&nbsp;plugins {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android") version "2.52" apply false
&nbsp;3.  Then, apply the Gradle plugin and add these dependencies in your app/build.gradle.kts file:
&nbsp;&nbsp;plugins {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("kotlin-kapt")  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android")

&nbsp;&nbsp;// Allow references to generated code
&nbsp;&nbsp;kapt  {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;correctErrorTypes = true
&nbsp;&nbsp;}

&nbsp;dependencies {
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.hilt.android)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kapt(libs.hilt.android.compiler)
