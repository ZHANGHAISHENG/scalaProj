package learn.SAM

object Test3 {

/*  def indexOf(str:String,ch:Char): Int = {
       var i = 0
       until (i == str.length){
         if(str(i) == ch) return i
         i += 1
       }
    return -1
  }
  */

   /*def runInThread(block:() => Unit): Unit ={
       new Thread(){
         override def run() { block()}
       }.start()
   }*/

  /*def runInThread(block: => Unit): Unit ={
    new Thread(){
      override def run() { block}
    }.start()
  }*/

  def until(condition: => Boolean)(block: => Unit) {
      if(!condition){
        block
        until(condition) (block)
      }
  }

  def indexOf(str:String,ch:Char): Int = {
       var i = 0
       until (i == str.length){
         if(str(i) == ch) return i
         i += 1
       }
    return -1
  }

  def main(args: Array[String]): Unit = {

    //runInThread{() => println("Hi"); Thread.sleep(1000);println("bye")}
    //runInThread{ println("Hi"); Thread.sleep(1000);println("bye")}

    /*var x = 10
    until (x == 0){
      x -= 1
      println(x)
    }*/

    println(indexOf("hello world",'d'))

    val map1 = scala.collection.mutable.Map("alice" -> 10,"Bob"  -> 3,"Cindy" -> 8)//可变map
    val map2 = scala.collection.immutable.Map("zhs" ->3,"ls" ->4)
    map1("zhs") = 5
  }
}
