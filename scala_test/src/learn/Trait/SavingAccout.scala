package learn.Trait

class SavingAccout extends Logger {

  def withdraw(msg:String){log("saving"+msg)} // 没有指定是super.log,否则new　SavingAccout　with trait 不起作用

}

object SavingAccout{
  def main(args: Array[String]): Unit = {

    val acct1 = new SavingAccout
    acct1.withdraw("1000$") // 调用Logger中的log saving1000$

    val acct2 = new SavingAccout with FileLogger with  ConsoleLogger with Logger// 调用Console中的log(),子类优先，再比较顺序
    acct2.withdraw("1000$")// saving1000$->console->file

  }
}
