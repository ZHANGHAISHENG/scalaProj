package learn.Match

object Test {

  def main(args: Array[String]): Unit = {

     var sign = 0
     val ch = '8'

  /*   // 当switch用
     ch match{
       case '+' => sign =  1
       case '-' => sign = -1
       case a  =>  println(a)
     }

     println(sign)


    ch match{
      case '+' => sign =  1
      case '-' => sign = -1
      case _   if Character.isDigit(ch) => sign = Character.digit(ch,10)
      case _   => sign = 0
    }
*/
    /*println(sign)

    val obj:Any = "" //obj必须是不能为　val obj:Char = '' 或　val obj = ""
    obj match{
      case x: Int => println("Int")
      case s: Char => println("Char")
      case _: Double => println("BigInt")
      case _ => println(0)
    }
*/
    val arr = Array(0,1,2)

    arr match {
      case Array(0) => println(0) //Array(0)
      case Array(x,y) => println("x y")
      case Array(0,_*) => println("0,_*")
    }

    val lst = List(1,2)
    lst match{
      case 0 :: Nil => "0"
      case x :: y :: Nil => println(x+" "+ y)
      case 0 :: tail => println("0....")
    }

    val pair = (0,1)
    pair match {
      case (0,_) => println("0...")
      case (y,0) => println(y+" 0")
    }


  }

}
