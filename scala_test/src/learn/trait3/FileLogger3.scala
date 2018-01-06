package learn.trait3

import java.io.PrintStream

trait FileLogger3 extends Logger3{
   val filename: String
   val out = new PrintStream(filename) //　使用了抽象属性
   def log(msg:String) {out.println(msg); out.flush()}

}
