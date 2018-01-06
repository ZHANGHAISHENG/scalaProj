package learn.HightType


trait LoggerComponent {
  trait Logger {  def log(msg: String) }
  val logger: Logger
  class FileLogger(file: String) extends Logger {
    def log(msg: String) =  println("File: " + msg)
  }

}

trait AuthComponent {
  this: LoggerComponent => // 让我们可以访问日志器
  trait Auth {
    this: Logger => def login(id: String, password: String): Boolean
  }
  val auth: Auth
  class MockAuth(file: String) extends Logger with Auth { //需要先混入Logger
    def login(id: String, password: String): Boolean = true
    override def log(msg: String): Unit = println("Authlog:"+msg)
  }

}

// 使用组件
object AppComponents extends  LoggerComponent with AuthComponent {
  val logger = new FileLogger("test.log")
  val auth = new MockAuth("users.txt")
}

object Type4Test {
  def main(args: Array[String]): Unit = {
      println(AppComponents.auth.login("",""))
      AppComponents.auth.log("hello")
      AppComponents.logger.log("hello")

  }
}
