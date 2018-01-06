package learn.Either

import java.net.URL
import scala.io.Source

/**
Either[A, B] 要么包含一个类型为 A 的实例，要么包含一个类型为 B 的实例
Either 只有两个子类型： Left、 Right
Either 并没有指定哪个子类型代表错误，哪个代表成功
  */
object EitherTest1 {

  //获取URL资源函数
  def getContent(url: URL): Either[String, Source] ={
    if(url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))
  }

  //for
  def averageLineCountWontCompile(url1: URL, url2: URL): Either[String, Int] =
    for {
      source1 <- getContent(url1).right
      source2 <- getContent(url2).right
      lines1 = source1.getLines().size
      lines2 = source2.getLines().size
    } yield (lines1 + lines2) / 2

  //同上：把 for 语法糖去掉:for 语句只不过是 flatMap 嵌套调用的语法糖
  def averageLineCountDesugaredWontCompile(url1: URL, url2: URL): Either[String, Int] =
    getContent(url1).right.flatMap { source1 =>
      getContent(url2).right.map { source2 =>
        val lines1 = source1.getLines().size
        val lines2 = source2.getLines().size
        (lines1, lines2)
      }.map { case (x, y) => (x + y) / 2 }
    }

  /**
    不太理解产生的问题：
    for产生问题：在 for 语句中追加新的值定义会在前一个 map 调用上自动引入另一个 map 调用，
    前一个 map 调用返回的是 Either 类型，不是 RightProjection 类型，
    而 Scala 并没有在 Either 上定义 map 函数，因此编译时会出错
    解决如下：
    */
  def averageLineCount(url1: URL, url2: URL): Either[String, Int] =
    for {
      source1 <- getContent(url1).right
      source2 <- getContent(url2).right
      lines1 <- Right(source1.getLines().size).right
      lines2 <- Right(source2.getLines().size).right
    } yield (lines1 + lines2) / 2

  def main(args: Array[String]): Unit = {

    /**用法**/
    getContent(new URL("http://google.com")) match {
      case Left(msg) => println(msg) //执行
      case Right(source) =>  source.getLines().foreach(println _) //可能会有异常抛出
    }

    //立场：Either 不做任何假设，调用 left 或 right 方法，就能得到 Either 的 LeftProjection 或 RightProjection实例

    /**映射**/
    val moreContent: Either[String, Iterator[String]] =
      getContent(new URL("http://google.com")).right.map(_.getLines) //由于返回的是left，不会执行

    /**Flat Mapping:嵌套使用 map 所造成的令人费解的类型结构**/
    val url1 = "file:///home/zhanghaisheng/myWork/test/file1.txt"
    val part5 = new URL(url1)
    val part6 = new URL(url1)
    //>>map计算两个文件的平均长度
    val content1 = getContent(part5).right.map(a =>
      getContent(part6).right.map(b =>
        (a.getLines().size + b.getLines().size) / 2))

    println(content1)//Right(Right(3)) --> Either[String, Either[String, Int]]
    println(getContent(part5).right)//RightProjection(Right(non-empty iterator))
    println(getContent(part5).right.map(a => a.getLines().size))//Right(3)

    //>>flatMap计算两个文件的平均长度
    val content2 = getContent(part5).right.flatMap(a =>
      getContent(part6).right.map(b =>
        (a.getLines().size + b.getLines().size) / 2))
    println(content2) // Right(3) --> Either[String, Int]
    //println(getContent(part5).right.flatMap(a => a.getLines().size) //不能这样写，编译不通过，返回类型不是Either
    //List(1,2).flatMap(List(_))

    /**for**/
    val u1 = new URL(url1)
    val u2 = new URL(url1)
    val r1 = averageLineCountWontCompile(u1,u2)
    println("hello:"+r1) // hello:Right(3)

    val r2 = averageLineCountDesugaredWontCompile(u1,u2)
    println("hello:"+r2)//hello:Right(3)

    val r3 = averageLineCount(u1,u2)
    println("hello:"+r3)//hello:Right(3)


    val a = getContent(u2).right.map { source2 =>
      (1, 2)
    }
    println(a)
    println(a.map { case (x, y) => (x + y) / 2})

    /**Fold**/
    val content: Iterator[String] = getContent(u1).fold(Iterator(_), _.getLines())
    //Either[String, String] 变换成了 Iterator[String]
    content.foreach(println _)

  }

}
