package learn.trait3

/*
class SavingsAccount3 extends FileLogger3 {
   val filename: String = "" //　不能这样定义，由于超类中使用了该参数，由于加载顺序原因会报空指针错
   //这样需要超类中　lazy val out = new PrintStream(filename) 每次使用前都检查是否已初始化，效率不高
}

object  SavingsAccount3{

  def main(args: Array[String]): Unit = {
    val save = new SavingsAccount3
  }

}
*/


class SavingAccount３ extends {//　extends 后是提前定义块
  val filename = "saving.log"
}with FileLogger3{

}

object  SavingAccount３{

  def main(args: Array[String]): Unit = {
    val save = new SavingAccount３
    println("初始化结束")
  }
}