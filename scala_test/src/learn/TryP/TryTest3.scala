package learn.TryP

import java.io.{FileNotFoundException, InputStream}
import java.net.{MalformedURLException, URL}

import scala.io.Source
import scala.util.Try

object TryTest3 {

  def parseURL(url:String): Try[URL] = Try(new URL(url))

  def inputStreamForUrl1(url:String) : Try[Try[Try[InputStream]]] = parseURL(url).map{
    u => Try(u.openConnection()).map(conn => Try(conn.getInputStream))
  }

  def inputStreamForUrl2(url:String) : Try[InputStream] = parseURL(url).flatMap{
    u => Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
  }

  def parseHttpUrl(url:String) = parseURL(url).filter(_.getProtocol == "http")

  def getURLContent1(url:String): Try[Iterator[String]] = for{
    url <- parseURL(url)
    connection <- Try(url.openConnection())
    is <- Try(connection.getInputStream)
    source = Source.fromInputStream(is)
  } yield  source.getLines()

  def getURLContent2(url:String): Try[Iterator[String]] = for{
    url <- parseURL(url)
    source = Source.fromURL(url)
  } yield  source.getLines()

  def main(args: Array[String]): Unit = {

    /*val str:String = Source.stdin.mkString
    val url = parseURL(str) getOrElse  new URL("http://duckduckgo.com")
    println(url)*/

    /*val a = parseURL("http://danielwestheide.com").map(_.getProtocol)
    println(a)//Success(http)
    */

    /**发生异常，try map 与 flatMap链停止传递**/
    /*//val in1 = inputStreamForUrl1("aa")//Failure(java.net.MalformedURLException: no protocol: aa)
    //val in1 = inputStreamForUrl1("http://www.baidu.com1")//Success(Success(Failure(java.net.UnknownHostException: www.baidu.com1)))
    val in1 = inputStreamForUrl1("http://www.baidu.com") //Success(Success(Success(sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@511baa65)))
    println(in1)

    //val in2 = inputStreamForUrl2("aa")//Failure(java.net.MalformedURLException: no protocol: aa)
    val in2 = inputStreamForUrl2("http://www.baidu.com1")//Failure(java.net.UnknownHostException: www.baidu.com1)
    println(in2)
*/
    /**当 Try 是 Failure 时， foreach 不会执行，返回 Unit 类型。**/
    val p1 = parseHttpUrl("http://www.baidu.com")
    val p2 = parseHttpUrl("ftp://mirror.netcologne.de/apache.org") // 假设ftp地址能被访问,results in a Failure[URL]
    println(p1)
    println(p2)

    /*println("*********")
    val content = getURLContent1("garbage") recover {
      case e: FileNotFoundException => Iterator("Requested page does not exist")
      case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
      case _ => Iterator("An unexpected error has occurred. We are so sorry!")
    }

    content.get.foreach(println _)

    */
  }

}
