package learn.operation

class IsCompound {

}


object  IsCompound {

  def unapply(input: String) = input.contains(" ")

  def main(args: Array[String]): Unit = {
    val IsCompound()  = "hello"
  }

}