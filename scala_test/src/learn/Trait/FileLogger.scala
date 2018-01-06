package learn.Trait

trait FileLogger extends Logger {

  override def log(msg: String): Unit = { super.log(msg + "->file")}

}

