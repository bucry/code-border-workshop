// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.2")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.5")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")

// Haxe plugin
addSbtPlugin("com.thoughtworks.microbuilder" % "sbt-haxe" % "3.0.10")

addSbtPlugin("com.thoughtworks.sbt-best-practice" % "sbt-best-practice" % "latest.release")

// Scala.js
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.8")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.6.1")

addSbtPlugin("com.thoughtworks.sbt-scala-js-map" % "sbt-scala-js-map" % "1.0.1")

addSbtPlugin("com.github.saurfang" % "sbt-spark-submit" % "0.0.4")

resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

addSbtPlugin("org.spark-packages" % "sbt-spark-package" % "0.2.3")
