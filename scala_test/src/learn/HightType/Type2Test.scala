package learn.HightType


trait Logged {
  def log(msg: String)
}

trait LoggedExceptoin extends Logged {

  this: Exception =>
  def log1() {
    log("msg:"+getMessage())
  }

  //可以调用getMessage，因为this是一个Exception

}

class myException extends Exception {
  def log(msg: String) = println(msg)
}

class myException2 extends myException {
  override def log(msg: String) = println(msg)
}
/*class NetWork(val name: String, val age: Int) {

}

//Group 要求它被添加到NetWork的子类，在Member中用outer来使用NetWork的属性
trait Group {
  outer: NetWork =>
  class Member {
    def dsc = "name:"+outer.name+" age:"+outer.age
  }

}*/


object Type2Test {

  def main(args: Array[String]): Unit = {
    val f = new myException2 with LoggedExceptoin // 错误：myException　不是　LoggedExceptoin　的子类
    f.log1()
  }

}
