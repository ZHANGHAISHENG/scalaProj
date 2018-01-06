package learn.SAM

object Test4 {

  //遍历list
  def sum(lst:List[Int]):Int = if(lst == Nil) 0 else lst.head + sum(lst.tail)

  def main(args: Array[String]): Unit = {
    val list = 9::4::2::Nil
    println(sum(list))
    println(list.sum)

    val digits = Set(1,2,3)
    println(digits contains 0) // false
    println(Set(1,2) subsetOf(digits)) // true

    val s1 = Seq(1,2)
    val s2 = Seq(3)

    Iterator


  }
}

/*val set = Set(1,2,3)
set + 3*/
