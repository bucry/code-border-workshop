scalaVersion in ThisBuild := "2.11.8"
organization in ThisBuild := "com.baifachuan"

publishTo in ThisBuild := Some(Resolver.file("file", new File(Path.userHome.getAbsolutePath + "/.m2/repository")))

sparkVersion in ThisBuild := "2.0.2"


(packageBin in Compile) <<= (packageBin in Compile) dependsOn (dist in `data-lake`)

lazy val root = project in file(".")

lazy val `data-lake` = project in file("data-lake")
lazy val `spark-spike` = project in file("spark-spike")
lazy val `hadoop-spike` = project in file("hadoop-spike")


val versionNo = sys.env.get("VERSION") match {
  case Some(number) => number.toString
  case _ => "1.0"
}

val buildVersion = sys.env.get("GO_PIPELINE_COUNTER") match {
  case Some(number) => s"$versionNo.$number"
  case _ => s"$versionNo-SNAPSHOT"
}

lazy val makeVersionTxt = taskKey[File]("Make version.txt")

makeVersionTxt := {
  val file = target.value / "version.txt"
  IO.write(file, version.value)
  file
}
