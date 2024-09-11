
Starting in Kotlin 2.0, the Compose Compiler Gradle plugin is required
when compose is enabled. See the following link for more information:
https://d.android.com/r/studio-ui/compose-compiler

&nbsp;&nbsp;1.  In your libs.versions.toml file, remove any reference to the Compose compiler
&nbsp;&nbsp;2.  In the plugins section, add the following new dependency
&nbsp;&nbsp;&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
&nbsp;&nbsp;1.  In your projects root build.gradle.kts file, add the following to the plugins section:
&nbsp;&nbsp;&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler) apply false
&nbsp;&nbsp;1.  In each module that uses Compose, apply the plugin:
&nbsp;&nbsp;&nbsp;&nbsp;[plugins]
&nbsp;&nbsp;&nbsp;&nbsp;alias(libs.plugins.compose.compiler)

