import sbt._
import Keys._
import play.Project

object ApplicationBuild extends Build {
  val appName         = "Schoolbook"

  val appVersion      = "0.1"

  val appDependencies = Seq(
    "org.webjars" %% "webjars-play" % "2.2.0-RC1",
    "org.webjars" % "bootstrap" % "3.0.3",
    "mysql" % "mysql-connector-java" % "5.1.18"
  )

  val main = Project(appName, appVersion, appDependencies).settings()
}