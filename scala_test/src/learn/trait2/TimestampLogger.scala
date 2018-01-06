package learn.trait2

trait TimestampLogger extends Logger2{

  abstract  override def log(msg: String): Unit = { //由于super.log没有实现，所以必须加上abstract　控制，注意不能忘记override
    //重写抽象方法
    super.log(new java.util.Date() + " " + msg) // super.log 不等同于java中的super.log
  }

}

