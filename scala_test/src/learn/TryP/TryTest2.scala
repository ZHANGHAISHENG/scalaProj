package learn.TryP

import scala.util.Try

object TryTest2 {
  def deviceBy(x:Int,y:Int):Try[Int] = {
    Try(x / y)
  }
  def main(args: Array[String]): Unit = {


    val f:PartialFunction[Throwable,Try[List[String]]] = {
      case e:ArithmeticException => Try(List("ArithmeticException error"))
      case _ => Try(List("unknow error"))
    }

    val content = deviceBy(1,0).recover(f)
    //content类型：scala.util.Try[Any] = Success(List(ArithmeticException error))
    println(content.get)//List(ArithmeticException error)

   /* val content = deviceBy(1,0).recoverWith{
      case e:ArithmeticException => Try(1)
      case _ => Try(0)
    }
    //content类型：scala.util.Try[Int] = Success(1)
    println(content.get)//1*/

    /*val content2 = deviceBy(1,0).transform((x:Int) => Try("val is:"+x),(x:Throwable)=> Try(x.getMessage))
    println(content2.get)*/

  }

}


