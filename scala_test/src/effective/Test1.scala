package effective

import java.net.InetSocketAddress

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}


object Test1 {

  def main(args: Array[String]): Unit = {
    /*val addrToInet: Int => Long = _.toLong
    println(addrToInet(1))*/

    val a1:Int => Int = _*2
    val a2:Int => String = "hello"+_
    val a3 = a1 andThen a2 // (x => a2(x))
    println(a3(1)) // 等同于：println(a2(a1(1)))


    val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10))
    val orderedVotes1 = votes
      .groupBy(_._1)
      .map { case (which, counts) =>
        (which, counts.foldLeft(0)(_ + _._2))
      }.toSeq
      .sortBy(_._2)
      .reverse
    //groupBy结果：Map(scala -> List((scala,1), (scala,10), (scala,1)), java -> List((java,4)), python -> List((python,10)))
    //map结果：Map(scala -> 12, java -> 4, python -> 10)
    println(orderedVotes1)//结果：Vector((scala,12), (python,10), (java,4))


    //替换分步操作如下：分组，求和，排序
    val votesByLang = votes groupBy { case (lang, _) => lang }
    val sumByLang = votesByLang map { case (lang, counts) =>
      val countsOnly = counts map { case (_, count) => count }
      (lang, countsOnly.sum) //countsOnly.sum = ountsOnly.foldLeft(0)(_ + _)
    }
    val orderedVotes2 = sumByLang.toSeq
      .sortBy { case (_, count) => count }
      .reverse
    println(orderedVotes2)


    //flatmap 用for 代替
    val chars = 'a' to 'z'
    val perms1 = chars flatMap { a =>
      chars flatMap { b =>
        if (a != b) Seq("%c%c".format(a, b))
        else Seq()
      }
    }
    println(perms1)

    //同下
    val perms2 = for {
      a <- chars
      b <- chars
      if a != b
    } yield "%c%c".format(a, b)

    val host: Option[String] = Option("www.baidu.com")
    val port: Option[Int] = Option(80)
    val addr1: Option[InetSocketAddress] =
      host flatMap { h =>
        port map { p =>
          new InetSocketAddress(h, p)
        }
      }
    println(addr1)

    //同下：
    val addr2: Option[InetSocketAddress] = for {
      h <- host
      p <- port
    } yield new InetSocketAddress(h, p)
    println(addr2)

    val f = (i: Int) => i.toString
    val g = (s: String) => s+s+s
    val h = g compose f  // : Int => String
    println(h(1)) // 等同于  println(g(f(1)))




  }

}
