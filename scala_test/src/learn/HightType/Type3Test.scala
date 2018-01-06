package learn.HightType

trait Logger {
  def log(msg: String)
}


trait FileLogger extends Logger {
  override def log(msg: String) = {
    println("File: " + msg)
  }
}

// 用户认证特质有一个对日志功能的依赖
trait Auth {
  this: Logger =>
  def login(id: String, password: String): Boolean
}

trait MockAuth extends Logger with Auth{
   def log(msg: String): Unit = println("MockAuth:"+msg)
   def login(id: String, password: String): Boolean = true
}

// 应用逻辑有赖于上面两个特质
trait App {
 // this: Logger with Auth => // 等同于this: with Auth =>
}

object MyApp extends App  with MockAuth


object Type3Test {

  def main(args: Array[String]): Unit = {
    MyApp.log("hello")  //冲突，不知道调用哪个log（FileLogger与MockAuth）
    println(MyApp.login("",""))

  }

}
