package learn.Types

/*
class Person{}
class Student extends  Person {}

class Pair[+T] (val first: T, val second: T){
  def makeFriends(p : Pair[Person]) = {}
}
*/

/*
trait Friend[-T] {
  def befriend(someone: T)
}
class Person extends Friend[Person]{
  override def befriend(someone: Person): Unit = println("ok")
}
class Student extends Person {}
*/

abstract class List[+T]{}

//object  Empty[T] extends List[T] //错误
object  Empty extends List[Nothing]

object TypeTest2 {


  //单参数函数的类型为Function1[-A, +R]
  /*def friends(students: Array[Student], find: Function1[Student, Person]) = {
    //第二个参数可以写成　find:Student => Persion
    for (s <- students) yield find(s)
  }
*/
  //def  findStudent(p:Person) :Student = { return new Student}

  def main(args: Array[String]): Unit = {
//    val p = new Pair[Person](new Person,new Person)
//    p.makeFriends(new Pair[Student](new Student,new Student))



    /*val s = new Student
    val p = new Person*/

    // 有这么一个函数
    /* def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }

     makeFriendWith(s,p)*/


    //在Scala中，对于协变的Pair类，不需要通配符。但是假定Pair是不变的：
    /*class Pair[T] (var first: T, var second: T)
    // 可以定义函数：
    def makeFriends (p: Pair[_ <: Person]){}  // 可以用Pair[Student]调用

    //逆变使用通配符：
    import java.util.Comparator
    def min[T](p: Pair[T]) (comp: Comparator[_ >: T]){}*/

  }

}
