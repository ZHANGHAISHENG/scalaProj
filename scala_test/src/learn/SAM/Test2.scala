package learn.SAM

object Test2 {

  // def corresponds[B](thant:Seq[B])(p:(A,B) => Boolean):Boolean
  // def mul(x:Int,y:Int) = x *y
  //def mul(x:Int) = (y:Int) => x * y
  def mul(x:Int)(y:Int) = x *y
  def main(args: Array[String]): Unit = {
    println(mul(6)(7))

    val a = Array("Hello","World")
    val b = Array("Hello","World")
    println(a.corresponds(b)(_.equalsIgnoreCase(_))) // true


  }

}



