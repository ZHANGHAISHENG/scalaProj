package learn.ClassAlias


object Test3 {
  case class Email(
      subject: String,
      text: String,
      sender: String,
      recipient: String
    )
  type EmailFilter = Email => Boolean //类型别名

  val sentByOneOf1: Set[String] => EmailFilter ={
    senders =>
      email => senders.contains(email.sender)
  }
  //这样就省去了使用循环来判断true 或 false
  val sentByOneOf2: (Set[String]) => (Email => Boolean) ={
    senders =>
      email => senders.contains(email.sender)
  }

  //高阶函数 - 重用已有函数
  type SizeChecker = Int => Boolean
  val sizeConstraint: SizeChecker => EmailFilter =
    f =>
      email => f(email.text.size)

  val maximumSize1: Int => EmailFilter =
    n =>
      email => email.text.size <= n

  val maximumSize2: Int => EmailFilter =
    n =>
      sizeConstraint(_ <= n)

  def main(args: Array[String]): Unit = {

  }

}
