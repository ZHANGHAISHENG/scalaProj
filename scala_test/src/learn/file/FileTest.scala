package learn.file

import java.io._

import scala.io.Source

object FileTest {

  def main(args: Array[String]): Unit = {
   /* val source1 = Source.fromFile("/home/zhanghaisheng/myWork/file1.txt","UTF-8")


    val contents = source1.mkString //返回文本
    println("|"+contents+"|")

    val source2 = source1.reset()
    val lineIterator = source2.getLines() //返回一个迭代器
    println("start:---")
    for(s <- lineIterator) println(s)
    println("end:---")

    val source3 = source1.reset()
    val lines = source3.getLines().toArray //返回数组
    println("start:---")
    for(i <- 0 until lines.length) println(lines(i))
    println("end:---")*/
    //--------读取字符-------------
/*

    val source1 = Source.fromFile("/home/zhanghaisheng/myWork/file1.txt","UTF-8")

    val iter = source1.buffered
    while(iter.hasNext){
       if(iter.head  == '1'){
          println("获取到了需要的字符："+iter.next())
       }else{
          println("不需要的字符："+iter.next())
       }
    }
*/


    // --------读取词法和数字-------------
    /*val source1 = Source.fromFile("/home/zhanghaisheng/myWork/file1.txt","UTF-8")
    val tokens = source1.mkString.split("\\s+")
    println(tokens.length)*/

    // ---------从url 和其他源赌气读取-------------
/*

    val source1 = Source.fromURL("http://","UTF-8")
    val source2 = Source.fromString("hello world!")
    val source3 = Source.stdin // ctrl + d　结束控制台输入
    val line = source3.mkString
    println(line)

*/

    // ---------读取二进制文件(scala　本身没有提供，需要使用java　类库)------------
    /*val file = new File("/home/zhanghaisheng/myWork/file1.txt")
    val in = new FileInputStream(file)
    val buf = new Array[Byte](1024)
    var n = in.read(buf)
    while( n > 0){
       for(i <- 0 to n-1) print(buf(i).toChar)
       n = in.read(buf)
    }
    println(buf.length)
    in.close()*/

    // ---------写入文本文件(scala　本身没有提供，需要使用java　类库)----------------------------------------------------
    /*val out = new PrintWriter("/home/zhanghaisheng/myWork/file1.txt")
    for(i <- 1 to 10) out.print(" "+i)
    out.close()*/

    //目录
    /*val f = new File("/home/zhanghaisheng")
    println(f.isDirectory())
    println(f.listFiles().length)*/


   val animal = new Animal()
    println(animal.name)
    val out = new ObjectOutputStream(new FileOutputStream("/home/zhanghaisheng/myWork/tmp/animal.obj"))
    out.writeObject(animal)
    out.close();
    val in = new ObjectInputStream(new FileInputStream("/home/zhanghaisheng/myWork/tmp/animal.obj"))
    val obj = in.readObject().asInstanceOf[Animal]
     println(obj.name)




  }

}
