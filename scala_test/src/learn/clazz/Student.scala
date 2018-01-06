package learn.clazz

class Student extends  Persion {

  override val name: String = ""

}

object  Student{

  def main(args: Array[String]): Unit = {
    val obj = new Student
    println(obj.isInstanceOf[Persion]) // true
    println(obj.asInstanceOf[Persion]) // learn.clazz.Student@7e0babb1hello
    println(obj.getClass == classOf[Persion]) // false
    println(obj.getClass == classOf[Student]) // true
  }

}
