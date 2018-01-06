package learn.seq

object SeqTest2 {

  object  Obj{
    def unapplySeq(input:String):Option[Seq[String]] = {
      Some(input.split("\\s+"))
    }
  }

  def main(args: Array[String]): Unit = {
    val Obj(first1,second1) = "Hello world zhs" // 调用unapply方法
    println(first1+" "+second1)
  }

}
