package frame.circe

import io.circe._, io.circe.parser._

object Test2 {

  def main(args: Array[String]): Unit = {

    val json: String = """
        {
          "id": "c730433b-082c-4984-9d66-855c243266f0",
          "name": "Foo",
          "counts": [1, 2, 3],
          "values": {
            "bar": true,
            "baz": 100.001,
            "qux": ["a", "b"]
          }
        }
      """

    val doc: Json = parse(json).getOrElse(Json.Null)

  }
}
