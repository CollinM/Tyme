name := "Tyme"

version := "0.1.1"

scalaVersion := "2.10.2"

// Add One-Jar settings
seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

// Dependencies
libraryDependencies += "org.scalaj" % "scalaj-http_2.10" % "0.3.10"

libraryDependencies += "net.liftweb" % "lift-json_2.10" % "2.5.1"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10.2"