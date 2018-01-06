package learn.operation

class SeqTest {

}

object SeqTest{

  def unapplySeq(input:String):Option[Seq[String]] = {

    Some(input.split("\\s+"))

  }

  def main(args: Array[String]): Unit = {
     val SeqTest(first1,second1,third) = "Hello world zhs" // 调用unapply方法
     //val SeqTest(first1,second1) = "Hello world zhs" // 数量不匹配将报错
     println(first1+" "+second1+" "+third)
  }

}
