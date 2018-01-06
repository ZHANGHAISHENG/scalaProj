package learn.implicitP

import java.io.File
import scala.io.Source

object ImplicitTest {

  //RichFile类中定义了Read方法
  class RichFile(val file: File) {
    def read = Source.fromFile(file).getLines().mkString
  }

  //RichFileAnother类，里面定义了read2方法
  class RichFileAnother(val file:RichFile){
    def read2=file.read
  }

  def main(args: Array[String]): Unit = {
    import learn.implicitP.ImplicitConversion.{richFile2RichFileAnother => _ ,_}

    //定义完隐式转换后，便可以直接将Double类型赋值给Int类型
/*    val x: Int = 3.5
    println(x) //3
    val f = new File("/home/zhanghaisheng/myWork/tmp/hello.txt").read
    println(f)*/

    def quote(what: String) (implicit left:String,right: String) = {  (left + " " + what + " " + right)} //别这样做，因为无法提供两个不同的字符串
    implicit val s  = "<<"
    println(quote("hello")) // << hello <<


  }


}
