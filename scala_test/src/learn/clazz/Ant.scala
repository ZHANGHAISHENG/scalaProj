package learn.clazz

class Ant extends Creature {
  override val range: Int = 2
}

object Ant{

  def main(args: Array[String]): Unit = {
     val ant = new Ant
     println(ant.range)    // 2
     println(ant.env.length) // 0
     val a = null // ()　或 Unit
     println(a == null) // == () 或 == Unit
     val m1 = Map(1->"x", 2->"y")
  }

}
