package learn.Either

import java.net.{MalformedURLException, URL}
import scala.util.control.Exception.catching

/**
  * 错误处理
  * 避免使用 Either 来封装意料之外的异常， 使用 Try 来做这种事情会更好，至少它没有 Either 这样那样的缺陷。
  */
object EitherTest3 {

  //处理错误函数
  def handling[Ex <: Throwable, T](exType: Class[Ex])(block: => T): Either[Ex, T] =
      catching(exType).either(block).asInstanceOf[Either[Ex, T]]

  def parseURL(url: String): Either[MalformedURLException, URL] =
      handling(classOf[MalformedURLException])(new URL(url))

  def main(args: Array[String]): Unit = {

    val a = parseURL("aa")
    val b = parseURL("http://www.baidu.com")
    println(a)//Left(java.net.MalformedURLException: no protocol: aa)
    println(b)//Right(http://www.baidu.com)

    /**其他例子**/
    case class Customer(age: Int)
    class Cigarettes
    case class UnderAgeFailure(age: Int, required: Int) //自定义异常信息
    def buyCigarettes(customer: Customer): Either[UnderAgeFailure, Cigarettes] =
        if (customer.age < 16) Left(UnderAgeFailure(customer.age, 16)) else Right(new Cigarettes)
    println(buyCigarettes(Customer(1)))

  }

}
