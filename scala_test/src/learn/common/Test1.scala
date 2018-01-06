package learn.common

object Test1 {
  def main(args: Array[String]): Unit = {
    trait Friend[-T] {
      def befriend(someone: T)
    }
    class Person extends Friend[Person]{
      override def befriend(someone: Person): Unit = println("ok")
    }
    class Student extends Person
    val s = new Student
    val p = new Person

    // 有这么一个函数
    def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }

    makeFriendWith(s,p)
  }
}
