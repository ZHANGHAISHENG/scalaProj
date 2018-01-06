package learn.Types

import java.io.File

import learn.clazz.Student

/*class Pair[T <: Comparable[T]] (val first:T,val second:T){
   def smaller = if(first.compareTo(second) < 0) first else second
}*/




/*
class Pair[T] (val first:T,val second:T){
  def replaceFirst[R >: T](newFirst:R) = new Pair[R](newFirst,second)
}
*/


/*
class Pair[T <% Comparable[T]](val first:T,val second:T){
  def smaller = if(first.compareTo(second) < 0) first else second
}
*/

/*
class Pair[T : Ordering] (val first:T,val second:T){
  def smaller(implicit ord:Ordering[T]) = {
    if (ord.compare(first,second) < 0) first else second
  }

}
*/


/*
class Pair[T] (val first:T,val second:T){
  def smaller(implicit ev:T <:< Ordered[T]) = {
    if (first < second) first else second
  }
}

*/


object TypeTest {

/*
  def makePari[T:Manifest](first:T,second:T):Array[T]={
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }
*/

  def main(args: Array[String]): Unit = {
    /*val p = new Pair(42,"String") // 这是一个Pair[Int,String] scala　自动推断出
    val p2 = new Pair[Any,Any](42,"String")//自己指定类型*/


    /*val p1 = new Pair[String]("a","b")
    println(p1.smaller)*/

    //val p2 = new Pair[String](new File(""),new File("")) // 编译报错，因为File不是Comparable子类

    /*val p = new Pair[Student](new Student, new Student)

    val p2 = p.replaceFirst(new Person)
    */

    /*val p = new Pair[Int](1,2)implicit
    println(p.smaller)*/

    /*val p1 = new Pair[Int](1,2)
    println(p1.smaller) // 由于有了implicit ord:Ordering[T]，可以不用传递参数*/


    //makePari(1,2)


    //　val p = Pair(new File(""),new File("")) //不报错
    //　p.smaller() //编译出错

    /*
    val friends = Map("fred" -> "barney")
    val f = friends.get("a")// Option[String]
    val fOrNull = f.orNull //　要么是String，要么是null

    val friends = Map("fred" -> 1)
    val f = friends.get("a")// Option[String]
    var fOrNull = f.orNull // 报错，因为　orNUll带有约束：　Null <:< A
    */

//    def firstLast[A,C <: Iterable[A]](it:C) = (it.head,it.last)
//    firstLast(List(1,2,3)) // 报错，无法推断出A是什么，因为它是同一个步骤中匹配A和C

//    def firstLast[A,C](it:C)(implicit ev:C <:< Iterable[A]) = (it.head,it.last)
//    firstLast(List(1,2,3)) //正确





  }

}
