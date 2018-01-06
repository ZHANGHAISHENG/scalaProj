package learn.seq


/**
  * 固定和可变的参数提取
  */
object SeqTest1 {

  //定义提取器
  object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
      val names = name.trim.split(" ")
      if (names.size < 2) None
      else Some((names.head,names.last, names.drop(1).dropRight(1)))
    }
  }

  //模式匹配中使用提取器
  def greet(fullName: String) = fullName match {
    case Names(firstName,lastName, _*) =>
      s"Good morning, $firstName $lastName!"
    case _ =>
      "Welcome! Please make sure to fill in your name!"
  }

  def main(args: Array[String]): Unit = {
    val str = greet("a b c d e f")
    println(str)

    val Names(firstName,lastName,res @ _*) = "a b c d e f"
    println(firstName+" "+lastName+" ")
    println(res)
  }

}
