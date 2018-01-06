package learn.implicitP

import scala.util.Try


object ImplicitTest4 {

/*  class Pair[T : Ordering] (val first:T,val second:T){
    def smaller(implicit ord:Ordering[T]) = {
      if (ord.compare(first,second) < 0) first else second
    }

  }*/

  /*class Pair[T : Ordering] (val first:T,val second:T){
    def smaller() = {
      //从Predef类的implicitly中获取该隐式值
      if (implicitly[Ordering[T]].compare(first,second) < 0) first else second
    }
  }
*/
/*  class Pair[T : Ordering] (val first:T,val second:T){
    def smaller() = {
      //利用Ordered特质中定义的从Ordering 到 Ordered的隐式转换
      import Ordered._
      if (first < second) first else second
    }
  }*/


  def main(args: Array[String]): Unit = {

     val a:String = null
     try {

     }catch {
       case ex:NullPointerException => println("null poiterException")
       case _ => println("unkonw exception")

     } finally {

     }


  }
}














