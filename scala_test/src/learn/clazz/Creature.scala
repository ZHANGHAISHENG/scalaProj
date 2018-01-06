package learn.clazz

class Creature {

  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
  //lazy val env: Array[Int] = new Array[Int](range) //效率不高,但env长度为子类重载的长度
}
