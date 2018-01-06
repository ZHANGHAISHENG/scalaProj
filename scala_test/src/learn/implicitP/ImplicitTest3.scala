package learn.implicitP

object ImplicitTest3 {

  //def smaller[T](a:T,b:T) = if( a < b) a else b //报错，无法确定a 带有 < 操作
  //def smaller[T](a:T,b:T)(implicit order:T => Ordered[T]) = if( order(a) < b) a else b
  //或
  def smaller[T](a:T,b:T)(implicit order:T => Ordered[T]) = if( a < b) a else b //将调用order(a) < b)

  def main(args: Array[String]): Unit = {
    println(smaller(1,2))


  }

}
