package learn.clazz

class Account private (val id:Int, balanceParam:Double) {
   private var balance = balanceParam
}

object Account {
  def apply(balanceParam: Double): Account = new Account(1, balanceParam)
  // 等同  def apply(balanceParam: Double) = new Account(1, balanceParam)

  def main(args: Array[String]): Unit = {
    val acc = Account(1000.0) //调用伴生类apply方法，返回伴生类对象
    println(acc.id)
    println(acc.balance)

    val arr1 = Array(100)     //调用伴生类apply方法，返回伴生类对象
    val arr2 = new Array(100)
    println(arr1(0))  // 100
    println(arr2(0))  // null
    println(arr1.length) // 1
    println(arr2.length) // 100
  }

}

