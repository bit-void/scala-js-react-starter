enablePlugins(ScalaJSBundlerPlugin)

name := "my-app"

scalaVersion := "3.1.0"

Compile / npmDependencies += "react" -> "17.0.2"
Compile / npmDependencies += "react-dom" -> "17.0.2"

Compile / npmDevDependencies += "file-loader" -> "6.2.0"
Compile / npmDevDependencies += "style-loader" -> "2.0.0"
Compile / npmDevDependencies += "css-loader" -> "5.2.6"
Compile / npmDevDependencies += "html-webpack-plugin" -> "4.5.1"
Compile / npmDevDependencies += "copy-webpack-plugin" -> "6.4.0"
Compile / npmDevDependencies += "webpack-merge" -> "5.8.0"

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "2.0.0"

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.9" % Test

webpack / version := "4.44.2"
startWebpackDevServer / version := "3.11.2"

webpackResources := baseDirectory.value / "webpack" * "*"

fastOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
fullOptJS / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
Test / webpackConfigFile := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

fastOptJS / webpackDevServerExtraArgs := Seq("--inline", "--hot")
fastOptJS / webpackBundlingMode := BundlingMode.LibraryOnly()

Test / requireJsDomEnv := true

addCommandAlias("dev", ";fastOptJS::startWebpackDevServer;~fastOptJS")

addCommandAlias("build", "fullOptJS::webpack")
