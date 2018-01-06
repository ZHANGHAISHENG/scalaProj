package learn.TryP

import scala.io.Source
import scala.util.{Failure, Success, Try}

object TryTest {

  def deviceBy(x:Int,y:Int):Try[Int] = {
    Try(x / y)
  }

  def readTextFile(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines.toList)
  }

  def main(args: Array[String]): Unit = {
     println(deviceBy(1,1).getOrElse(0)) // 0
     println(deviceBy(1,0).getOrElse(0)) // 0
     deviceBy(1,1).foreach(println _) //1
     deviceBy(1,0).foreach(println _) //没有输出

     deviceBy(1,0) match {
      case Success(i) => println("sucess,value is:"+i)
      case Failure(s) => s.printStackTrace()
     }


    Iterator("Requested page does not exist").foreach(println )


    val filename = "/home/zhanghaisheng/myWork/test/file1.txt"
    readTextFile(filename) match {
      case Success(lines) => lines.foreach(println)
      case Failure(f) => println(f)
    }

  }



}
