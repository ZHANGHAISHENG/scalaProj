package learn.seq

object Test {
  def main(args: Array[String]): Unit = {
    val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

    val a = for {
      list <- lists
    } yield list.size
    println(a) // List(3, 0, 2)

    val b = for {
      list @ head :: _ <- lists //不会匹配空列表
    } yield list.size
    println(b) // List(3, 2)

  }

}
