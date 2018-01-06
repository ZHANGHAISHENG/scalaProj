package learn.klh

object Test1 {

  case class Email(
                    subject: String,
                    text: String,
                    sender: String,
                    recipient: String)

  type EmailFilter = Email => Boolean


  def main(args: Array[String]): Unit = {

    type IntPairPred = (Int, Int) => Boolean

    def sizeConstraint1(pred: IntPairPred, n: Int, email: Email) = pred(email.text.size, n)

    val gt: IntPairPred = _ > _
    val ge: IntPairPred = _ >= _
    val lt: IntPairPred = _ < _
    val le: IntPairPred = _ <= _
    val eq: IntPairPred = _ == _ //等同：val eq1: IntPairPred = (a,b) => a == b


    val minimumSize: (Int, Email) => Boolean = sizeConstraint1(ge, _: Int, _: Email)
    val maximumSize: (Int, Email) => Boolean = sizeConstraint1(le, _: Int, _: Email)
    println(minimumSize(20, Email("subject1", "hello", "zhs", "recipient")))

    //从方法到函数对象
    val sizeConstraintFn1: (IntPairPred, Int, Email) => Boolean = sizeConstraint1 _
    println(sizeConstraintFn1(ge, 20, Email("subject1", "hello", "zhs", "recipient")))

    /** 柯里化函数:单参数的链式函数称 **/
    //更有趣的函数
    def sizeConstraint2(pred: IntPairPred)(n: Int)(email: Email): Boolean = pred(email.text.size, n)

    val sizeConstraintFn2: IntPairPred => Int => Email => Boolean = sizeConstraint2 _ // 等同于 sizeConstraintFn1.curried
    val minSize: Int => Email => Boolean = sizeConstraint2(ge) //等同于 sizeConstraint2(ge) _
    val maxSize: Int => Email => Boolean = sizeConstraint2(le)
    val min20: Email => Boolean = minSize(20) //sizeConstraintFn2(ge)(20)
    val max20: Email => Boolean = maxSize(20) //sizeConstraintFn2(le)(20)

    //对多参数函数柯里化
    val sum: (Int, Int) => Int = _ + _ //等同： val sum: (Int, Int) => Int = (a, b) => a + b
    val sumCurried:Int => Int => Int = sum.curried
    println(sumCurried(1)(2))

    //val sizeConstraintFn3:IntPairPred => Int => Email => Boolean = sizeConstraint1.curried //编译不通过
    //Unapplied methods are only converted to functions when a function type is expected.

    //柯里化行为本质上也是一个高阶函数：接受现有的函数，返回新函数
    //使用 Funtion.uncurried 进行反向操作，可以将一个柯里化函数转换成非柯里化版本。

  }

}