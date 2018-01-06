package learn.Trait

trait ConsoleLogger extends Logger {

  override def log(msg: String): Unit = { super.log(msg + "->console")}

}

