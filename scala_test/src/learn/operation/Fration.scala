package learn.operation

import scala.collection.mutable

class Fration(var n:Int,var d:Int) {

  def *(other:Fration):Int = new Fration(n * other.n,d * other.d).result
  val result = n * d


}

object  Fration{
  def apply( n: Int, d: Int): Fration = new Fration( n, d)
  def main(args: Array[String]): Unit = {
     println( Fration(1,2) *  Fration(1,2)) // 等同　 Fration(1,2).*( Fration(1,2))
  }


}
