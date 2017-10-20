package io.gatling.build

import sbt.Keys._
import sbt._

object BaseSettingsPlugin extends AutoPlugin {

  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements
  override def projectSettings = baseSettings

  def scalacOptionsVersion(v: String) = {
    Seq(
      "-encoding", "UTF-8",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-Xfuture",
      "-target:jvm-1.8"
    ) ++ (
        if (v.startsWith("2.11"))
          Seq("-Ybackend:GenBCode", "-Ydelambdafy:method")
        else
          Nil
      )
  }

  val baseSettings = Seq(
    homepage := Some(url("http://gatling.io")),
    organization := "io.gatling",
    organizationHomepage := Some(url("http://gatling.io")),
    startYear := Some(2011),
    scalaVersion := "2.12.4",
    updateOptions := updateOptions.value.withCachedResolution(true),
    javacOptions := Seq("-Xlint:-options", "-source", "1.8", "-target", "1.8"),
    resolvers := Seq(DefaultMavenRepository, Resolver.jcenterRepo),
    scalacOptions := scalacOptionsVersion(scalaVersion.value)
  )
}
