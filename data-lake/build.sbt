import sbt.Keys._

enablePlugins(PlayScala)

enablePlugins(UniversalDeployPlugin)

name := """data-lake"""

version := "1.0-SNAPSHOT"

sparkVersion := "2.0.2"

sparkComponents += "sql"

sparkComponents += "mllib"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  evolutions % Test,
  cache,
  ws,
  specs2 % Test,
  filters,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.databricks" %% "spark-csv" % "1.4.0",
  "com.github.tototoshi" %% "scala-csv" % "1.3.1",
  "org.elasticsearch" %% "elasticsearch-spark" % "2.2.1",
  "com.sksamuel.elastic4s" %% "elastic4s-core" % "2.3.1",
  "com.databricks" % "spark-xml_2.10" % "0.4.1",
  "org.xerial" % "sqlite-jdbc" % "3.8.11.2",
  "org.specs2" %% "specs2-mock" % "3.7.2" % Test,
  "org.specs2" %% "specs2-junit" % "3.7.2" % Test,
  "org.specs2" %% "specs2-core" % "3.7.2" % Test,
  "org.scalatestplus" %% "play" % "1.4.0-M3" % Test

)

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

incOptions := incOptions.value.withNameHashing(true).withRecompileOnMacroDef(false)

fork := true

javaOptions += "-Xmx8G"
javaOptions += "-Xss10m"

val matchPomConfig = ".*pom.(?:xml|properties)".r
val matchJnilib = ".*.jnilib".r
assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.last
  case PathList("javax", "activation", xs@_*) => MergeStrategy.last
  case PathList("org", "apache", xs@_*) => MergeStrategy.last
  case PathList("com", "google", xs@_*) => MergeStrategy.last
  case PathList("com", "google", "guava", xs@_*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs@_*) => MergeStrategy.last
  case PathList("com", "codahale", xs@_*) => MergeStrategy.last
  case PathList("com", "yammer", xs@_*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "META-INF/MANIFEST.MF" => MergeStrategy.discard
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case matchPomConfig() => MergeStrategy.last
  case matchJnilib() => MergeStrategy.last
  case x => MergeStrategy.last

}

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

routesGenerator := InjectedRoutesGenerator

publishArtifact in packageDoc in Compile := false
