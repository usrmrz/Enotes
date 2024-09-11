
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
https://developer.android.com/training/dependency-injection/hilt-android<br>

&nbsp;1.  In your libs.versions.toml file, in the plugins section, add the following new dependency<br>
&nbsp;&nbsp;[versions]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltAndroid = "2.52"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltLifecycleViewmodel = "1.0.0-alpha03"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltCompiler = "1.2.0"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltNavigationCompose = "1.2.0"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hiltAndroid" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hilt-android-compiler = { module = "com.google.dagger:hilt-android-compiler", version.ref = "hiltAndroid" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-hilt-lifecycle-viewmodel = { group = "androidx.hilt", name = "hilt-lifecycle-viewmodel", version.ref = "hiltLifecycleViewmodel" }<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-hilt-compiler = { group = "androidx.hilt", name = "hilt-compiler", version.ref = "hiltCompiler" }<br>

&nbsp;2.  Add the hilt-android-gradle-plugin plugin to your project's root build.gradle.kts file:<br>
&nbsp;&nbsp;plugins {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android") version "2.52" apply false<br>
&nbsp;3.  Then add these dependencies in your app/build.gradle.kts file:<br>
&nbsp;&nbsp;plugins {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("kotlin-kapt")<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;id("com.google.dagger.hilt.android")<br>

&nbsp;&nbsp;// Allow references to generated code<br>
&nbsp;&nbsp;hilt  {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;enableAggregatingTask = true<br>
&nbsp;&nbsp;}<br>

&nbsp;&nbsp;// Allow references to generated code<br>
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;hiltNavigationCompose = "1.2.0"<br>

&nbsp;&nbsp;[libraries]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;androidx-hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hiltNavigationCompose" }<br>

&nbsp;dependencies {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;implementation(libs.androidx.hilt.navigation.compose)<br>
