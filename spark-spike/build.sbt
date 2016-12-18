incOptions := incOptions.value.withNameHashing(true).withRecompileOnMacroDef(false)


libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

fork := true

javaOptions += "-Xmx8G"
javaOptions += "-Xss10m"