sbtPlugin := true

name := "sbt-simple-junit-xml-reporter-plugin"

organization := "ca.seibelnet"

version := "0.2.0"

sbtPlugin := true

publishMavenStyle := true

publishTo := Some("CPG Nexus" at "http://dev-generic-app001.vega.cloud.ironport.com/content/repositories/releases/")

credentials += Credentials("Sonatype Nexus Repository Manager", "dev-generic-app001.vega.cloud" +
	".ironport.com", "admin", "VX5x333f")
