package effective

import scala.concurrent.Future
import scala.io.Source
import scala.util.{Failure, Success}

object Test2 {

  def main(args: Array[String]): Unit = {

    /** Future创建方式 **/
    /*val f2 = Future.failed(new NullPointerException())
    val f3 = Future.successful("hello")
    val f4 = Future("hello")
    val f5 = Future(Failure(new NullPointerException()))
    val f6 = Future(Success("hello"))
    Thread.sleep(1000)

    println(f2) //Future(Failure(java.lang.NullPointerException))
    println(f3) //Future(Success(hello))
    println(f4) //Future(Success(hello))
    println(f5) //Future(Failure(java.lang.NullPointerException))
    println(f6) //Future(Success(hello))
    */

    /** Future **/
    import scala.concurrent.ExecutionContext.Implicits.global
    val result:Future[Int] = Future {
      Thread.sleep(100)
      1
    }
    val resultStr: Future[String] = result map { i => i.toString }
    println(resultStr) // Future(<not completed>) ,延迟
    /*
    val listOfList:List[List[Int]] = List(List(1,2),List(2,3))
    println(listOfList.flatten) // List(1, 2, 2, 3)
    */

    val b = Future{
      Future{
        1
      }
    }
    Thread.sleep(100)
    println(b) //Future(Success(Future(Success(1))))
    println(b.flatten) // Future(Success(1))
    val b2 = b.flatten.map(_*2)
    Thread.sleep(100)
    println(b2)

    val c = Future[Int]{
      1
    }
    Thread.sleep(100)
    c onComplete{
      case Success(_) => println("ok")
      case Failure(_) => println("fail")
    }

    /**递归**/
    //构建树
    case class Node(id:Int,parent: Option[Node])
    val n1 = Node(1,null)
    val n12 = Node(2,Some(n1))
    val n13 = Node(3,Some(n1))
    val n121 = Node(4,Some(n12))
    val n122 = Node(5,Some(n12))
    val n1221 = Node(6,Some(n122))
    val n1222 = Node(7,Some(n122))
    val tree = List(n1,n12,n13,n121,n122,n1221,n1222)
    //获取节点
    val getNode = (id:Int) =>{
       val lst = tree.filter(_.id == id)
       if(lst.size > 0) lst.head else None
    }

    //递归从自身节点到根节点
    def getH(id:Int,nodes:List[Int] = Nil):List[Int] = {
        getNode(id) match {
          case n@Node(i,Some(p)) => println(n);getH(p.id,i::nodes)
          case Node(_,null)=> nodes.reverse
        }
    }
    println(getH(6))

  }

}
