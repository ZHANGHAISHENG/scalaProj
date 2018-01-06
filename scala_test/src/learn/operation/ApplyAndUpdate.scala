package learn.operation

import scala.collection.mutable

object ApplyAndUpdate {

  def main(args: Array[String]): Unit = {
     val scores = new mutable.HashMap[String,Int]
     scores("Bob") = 100 // 调用udpate 方法　相当于scores.update("Bob",100)

     val bobsScore = scores("Bob")//相当于scores.apply
     println(bobsScore) // 100
  }
}
