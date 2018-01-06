package learn.HightType


import java.awt.geom.Area
import java.awt.print.Book
import java.io.Serializable
import javax.swing.JComponent

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/*
class Document {
  def setTitle(title:String):this.type = {println("setTilte"); this}
  def setAuthor(author:String):this.type = {println("setAuthor"); this}

}

class Book extends Document {
  def addChapter(chapter:String) = {println("setChapter"); this}
}
*/

/*
object Title

class Document {
  private var useNextArgAs: Any = null
  var title = ""
  def set(obj: Title.type): this.type = {useNextArgAs = obj; this}
  def to(arg: String) = if (useNextArgAs == Title) title = arg; else title = "unkonw"

}
class Book extends Document {
}
*/

class Parent{

}

/*
class Book1 extends parent{
  import scala.collection.mutable._
  type Index = HashMap[String, (Int, Int)]
  val a:Index = mutable.HashMap("a"->(1,2))
}
*/



class MyString extends Parent with Serializable {
  def append(str:String):Any =  {
    println("apendLines:"+str)
  }
}




object Type1Test{
  def appendLines(target: Parent with Serializable{ def append(str: String): Any }, lines: Iterable[String]) {
    for (l <- lines) { target.append(l)}
  }

  def main(args: Array[String]): Unit = {
   /* val book = new Book
    book.setTitle("title1").setAuthor("zhs").addChapter("c1")// setTitle 与　setAuthor　返回　this.type,所以推断为book
    book.addChapter("c1").setTitle("title1").setAuthor("zhs")*/

    /*val book = new Book
    book set Title to "scala for this Impatient" //等同于： book.set(Title).to("scala for Impatient")
    println(book.title)

    var f =  new Document*/

    //val b = new Book1
    //println(b.a)

    val myStr = new MyString
    val lst = List("zhs","ls")
    appendLines(myStr,lst)

    /*val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]

    val rect = new Ractangle(5, 10, 20, 30)
    image += rect   // OK , Rectangle是Serializable的
    //image += new Area(rect)  // error, Area是Shape但不是Serializable的
   */


  /*  val a1 :Array[_ <: JComponent] = null
    val a2 :Array[T] forSome {type T <: JComponent} = null

    val m1 : Map[_,_] = null
    val m2 : Map[T,U] forSome {type T;type U} = null

    val b: n.Member  forSome {val n:NetWork} = null

    def process[M <: n.Member  forSome {val n:NetWork}](m1:M,m2:M) = (m1,m2)
    // 该方法会接受相同网络的成员，但拒绝来自不同网络的成员
*/
  }



}
