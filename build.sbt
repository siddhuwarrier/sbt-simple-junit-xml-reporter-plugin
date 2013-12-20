sbtPlugin := true

name := "sbt-simple-junit-xml-reporter-plugin"

organization := "ca.seibelnet"

version := "1.0.0"

sbtPlugin := true

publishMavenStyle := true

publishTo := Some("Nexus" at "http://xxxx")

credentials += Credentials("Sonatype Nexus Repository Manager", "xxxx", "xxxxx", "xxxx")

