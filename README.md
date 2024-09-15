Relevant for September 2024
Android Studio Koala Feature Drop | 2024.1.2
Build #AI-241.18034.62.2412.12266719, built on August 23, 2024
Runtime version: 17.0.11+0--11852314 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.

Starting in Kotlin 2.0, the Compose Compiler Gradle plugin is required
when compose is enabled. See the following link for more information:<br>
https://d.android.com/r/studio-ui/compose-compiler<br>

&nbsp;1.  In your libs.versions.toml file, remove any reference to the Compose compiler<br>
&nbsp;2.  In the plugins section, add the following new dependency<br>
&nbsp;&nbsp;[plugins]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }<br>
&nbsp;3.  In your projects root build.gradle.kts file, add the following to the plugins section:<br>
&nbsp;&nbsp;[plugins]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler) apply false<br>
&nbsp;4.  In each module that uses Compose, apply the plugin:<br>
&nbsp;&nbsp;[plugins]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler)<br>

Dagger-Hilt<br>

&nbsp;1.  In your libs.versions.toml file, in the plugins section, add the following new dependency<br>
&nbsp;&nbsp;[versions]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltAndroid = "2.52"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltLifecycleViewmodel = "1.0.0-alpha03"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltCompiler = "1.2.0"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltNavigationCompose = "1.2.0"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltAndroid" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroid" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-hilt-compiler = { group = "androidx.hilt", name = "hilt-compiler", version.ref = "hiltCompiler" }<br>

&nbsp;2.  Add the hilt-android-gradle-plugin plugin to your project's root build.gradle.kts file:<br>
&nbsp;&nbsp;plugins {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android") version "2.52" apply false<br>

&nbsp;3.  Then add these dependencies in your app/build.gradle.kts file:<br>
&nbsp;&nbsp;plugins {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("kotlin-kapt")<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android")<br>

&nbsp;&nbsp;//Allow references to generated code<br>
&nbsp;&nbsp;hilt  {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;enableAggregatingTask = true<br>
&nbsp;&nbsp;}<br>

&nbsp;&nbsp;kapt  {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;correctErrorTypes = true<br>
&nbsp;&nbsp;}<br>

&nbsp;dependencies {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.hilt.android)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kapt(libs.hilt.android.compiler)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.hilt.lifecycle.viewmodel)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kapt(libs.androidx.hilt.compiler)<br>

Compose Dependency<br>

&nbsp;1.  In your libs.versions.toml file, in the plugins section, add the following new dependency<br>
&nbsp;&nbsp;[versions]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;lifecycleViewmodelCompose = "2.8.5"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;navigationCompose = "2.8.0"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;materialIconsExtended = "1.7.1"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltNavigationCompose = "1.2.0"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleViewmodelCompose" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-material-icons-extended = { group = "androidx.compose.material", name = "material-icons-extended", version.ref = "materialIconsExtended" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hiltNavigationCompose" }<br>

&nbsp;2.  Add this dependencies to your app/build.gradle.kts file:<br>
&nbsp;dependencies {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.lifecycle.viewmodel.compose)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.navigation.compose)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.material.icons.extended)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.hilt.navigation.compose)<br>

Coroutines<br>

&nbsp;1.  In your libs.versions.toml file, in the versions and libraries sections, add the following new lines<br>
&nbsp;&nbsp;[versions]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kotlinx-coroutines = "1.9.0-RC.2"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kotlinx-coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "kotlinx-coroutines" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kotlinx-coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinx-coroutines" }<br>

&nbsp;2.  In app/build.gradle.kts file apply the plugins:<br>
&nbsp;dependencies {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.kotlinx.coroutines.core)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.kotlinx.coroutines.android)<br>

Room<br>
&nbsp;1.  In your libs.versions.toml file, in the versions and libraries sections, add the following new lines<br>
&nbsp;&nbsp;[versions]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;room = "2.6.1"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }<br>

&nbsp;2.  In app/build.gradle.kts file apply the plugins. The comment is required:<br>
&nbsp;dependencies {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.room.runtime)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//noinspection KaptUsageInsteadOfKsp<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;kapt(libs.androidx.room.compiler)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.room.ktx)<br>
