package learn.HightType

object Test1 {

  case class Email(
          subject: String,
          text: String,
          sender: String,
          recipient: String
        )
  def main(args: Array[String]): Unit = {
    type EmailFilter = Email => Boolean //类型别名


    type IntPairPred = (Int, Int) => Boolean
    def sizeConstraint(pred: IntPairPred, n: Int, email: Email) = pred(email.text.size, n)


    val sizeConstraintFn: (IntPairPred, Int, Email) => Boolean = sizeConstraint _


    val sum: (Int, Int) => Int = _ + _
    val sumCurried: Int => Int => Int = sum.curried





  }

}
