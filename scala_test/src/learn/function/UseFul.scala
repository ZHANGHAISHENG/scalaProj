package learn.function

object UseFul {

  def main(args: Array[String]): Unit = {
    (1 to 9).map(0.1 * _)

    (1 to 9).map("*" * _).foreach(println _)

    (1 to 9).filter(_ % 2 == 0).foreach(println _)


    //二元函数
    val result = (1 to 9).reduceLeft(_ * _) //　相当于（...((1*2)*3)...）
    println(result)

    //二元函数排序
    "zhs ls ww zl".split(" ").sortWith(_.length < _.length)
    val a = Map("a"->1,"b"->2,"c"->3)
    val b = ("a","b")


    val ls = List(1,2,3)
    ls.map(x => x match {
      case 3 => List('a','b')
      case _ => List(x * 2)
    })

    def sortIntRule(i:Int) ={
      i match {
        case 1=> 2
        case 2=> 1
        case 3=> 4
        case _=> 0
      }
    }
    var list = List(1,2,3,6,4,8,9,0)
    println(list.sortBy(sortIntRule))

    def numsFrom(n:BigInt): Stream[BigInt] = n #:: numsFrom(n+1)
    val n = numsFrom(10)

    

  }

}
