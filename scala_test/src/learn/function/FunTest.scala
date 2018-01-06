package learn.function

object FunTest {

  def valueAtOneQuarter(f:(Double) => Double) = f(0.25)

  def mulby(factor:Double)  = (x:Double) => factor *x

  def main(args: Array[String]): Unit = {
    /*val num = 3.14
    val fun = math.ceil _ // _　将ceil方法转换成了函数
    println(fun(3.1))
    println(Array(3.14,1.42,2.0).map(fun))*/

    /*val triple = (x: Double) => 3 *x
    //等同 def triple = (x: Double) = 3 *x
    println(triple(2))

    println(Array(1,2,3).map((x: Int) => 3 *x))*/


    println(valueAtOneQuarter(math.ceil _))
    println(valueAtOneQuarter(math.sqrt _))
    println(valueAtOneQuarter((x:Double) => 3 * x))
    println(valueAtOneQuarter((x) => 3 * x))
    println(valueAtOneQuarter(3 * _))

    val quintuple = mulby(5)
    println(quintuple(20))

    val fun1 = 3 * (_:Double)
    println(fun1(3))

    val fun2:(Double) => Double = 3 * _
    println(fun2(3))

  }
}
