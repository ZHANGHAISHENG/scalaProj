package com.test

object Test1 {

  def toList(i:Int)  = {}
  def toList = {}

  def main(args: Array[String]): Unit = {

    println(Seq(1,2,3,4)(1))

    val a = List(List(1,2),List(2,3),List(3,4)).flatMap(x=> x)
    println(a)

    List((1,2),(3,4)).map{x => x}


   /* val test1: Option[List[(String, Seq[String])]] = ad.es.map {
      _.toList
    }

    val test2: Option[List[(Long, String)]] = ad.es.map {
      _.toList.flatMap { case (d, v) =>
        v.map((d.toLong, _))
      }
    }*/

   /* val t: Seq[(Int, String)] = List((1,List("a","b")),(2,List("c","d"))).flatMap{
      case (d,v) =>
        v.map((d,_))
    }

    println(t)

    var t2 = List((1,List("a","b")),(2,List("c","d"))).map{
      case (d,v) =>
        v.map((d,_))
    }
    println(t2)
*/
   val t1: Option[List[(String, String)]] =  Option(Map("1"->List("a","b"),"2"->List("c","d"),"3"->List("e","f"))).map(
      _.toList.flatMap{
        case (a,b) => b.map((_,a))
      }
    )
    println(t1)

    val t2: Option[List[(String, String)]] =  Option(Map("1"->List("a","b"),"2"->List("c","d"),"3"->List("e","f"))).map(
      _.toList.flatMap(
        x => x._2.map((_,x._1))
       )
    )
    println(t2)

    val t3: Option[List[(String, String)]] =  Option(Map("1"->List("a","b"),"2"->List("c","d"),"3"->List("e","f"))).map(
      _.toList.flatMap(
        x => x match{
          case (a,b) => b.map((_,a))
        }
      )
    )
    println(t3)

    //Some(List((1,List(a, b)), (2,List(c, d)), (3,List(e, f))))

    /*List((1,List("a", "b")), (2,List("c", "d")), (3,List("e", "f"))).map{
      case (a,b) => 1
    }*/


  }

}
