package io.gatling.build

import sbt.Keys._
import sbt._

object BaseSettingsPlugin extends AutoPlugin {

  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements
  override def projectSettings = baseSettings

  val baseSettings = Seq(
    homepage                  := Some(url("http://gatling.io")),
    organization              := "io.gatling",
    organizationHomepage      := Some(url("http://gatling.io")),
    startYear                 := Some(2011),
    licenses                  := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    scalaVersion              := "2.11.6",
    updateOptions             := updateOptions.value.withCachedResolution(true),
    javacOptions              := Seq("-Xlint:-options","-source", "1.7", "-target", "1.7"),
    scalacOptions             := Seq(
      "-encoding", "UTF-8",
      "-target:jvm-1.7",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-Xfuture"
    )
  )
}