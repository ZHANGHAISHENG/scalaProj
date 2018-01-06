package learn.operation

class Name {

}

object  Name {
  def unapply(input:String): Option[(String,String)] = {
    val pos = input.indexOf(" ")
    if(pos == -1) None //会抛出异常MatchError
    else Some(input.substring(0,pos),input.substring(pos+1))

  }

  def main(args: Array[String]): Unit = {
     val Name(first,last) = "Hello world" // 调用unapply方法
     println(first)
     println(last)

  }
}
