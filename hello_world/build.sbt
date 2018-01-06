name := "hello_world"

version := "0.1"

scalaVersion := "2.12.4"


val akkaV = "2.5.6"
val akkaHttpV = "10.0.10"
val circeV = "0.9.0-M2"

libraryDependencies ++= Seq(
   "io.circe"                     %% "circe-core"                 % circeV
  , "io.circe"                     %% "circe-generic"              % circeV
  , "io.circe"                     %% "circe-parser"               % circeV
  , "io.circe"                     %% "circe-generic-extras"       % circeV
)

/*"com.typesafe.akka"              %% "akka-slf4j"                 % akkaV
, "com.typesafe.akka"            %% "akka-actor"                 % akkaV
, "com.typesafe.akka"            %% "akka-stream"                % akkaV
, "com.typesafe.akka"            %% "akka-http-core"             % akkaHttpV
, "com.typesafe.akka"            %% "akka-http"                  % akkaHttpV*/