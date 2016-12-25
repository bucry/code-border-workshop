incOptions := incOptions.value.withNameHashing(true).withRecompileOnMacroDef(false)


sparkVersion := "2.0.2"
sparkComponents += "sql"
sparkComponents += "mllib"


fork := true

javaOptions += "-Xmx8G"
javaOptions += "-Xss10m"