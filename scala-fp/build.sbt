name := "scala-fp"

version := "0.1"

scalaVersion := "2.13.1"

scalastyleSources in Compile := (unmanagedSourceDirectories in Compile).value

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.21.0" % "test"
libraryDependencies += "org.scalatestplus" %% "mockito-3-2" % "3.1.1.0"

scalacOptions ++= Seq("-encoding", "UTF-8")