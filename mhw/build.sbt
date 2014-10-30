name := """mhw"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  "org.squeryl" %% "squeryl" % "0.9.5-7",
  "mysql" % "mysql-connector-java" % "5.1.10",
  cache,
  ws
)
