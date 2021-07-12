ThisBuild / organization := "io.github.awwsmm"
ThisBuild / organizationName := "awwsmm"
ThisBuild / organizationHomepage := Some(url("https://awwsmm.com"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/awwsmm/zepto"),
    "scm:git@github.com:awwsmm/zepto.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "awwsmm",
    name  = "Andrew Watson",
    email = "awilliamwatson@gmail.com",
    url   = url("https://awwsmm.com")
  )
)

ThisBuild / description := "A teeny, tiny shell for interactive Scala applications."
ThisBuild / licenses := List("The Unlicense" -> new URL("https://unlicense.org/"))
ThisBuild / homepage := Some(url("https://github.com/awwsmm/zepto"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true

ThisBuild / versionScheme := Some("early-semver")