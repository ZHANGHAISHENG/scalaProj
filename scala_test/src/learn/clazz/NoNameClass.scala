package learn.clazz

class NoNameClass {

}

object NoNameClass{



  def meet(p :Persion{def greeting:String}): Unit ={
    println(p.name+" says:" + p.greeting)

  }

  def main(args: Array[String]): Unit = {
      val alien = new Persion(){  //　Persion 必须已存在
         def greeting = "Greetings,Earthling! My name is Fred"
      }
      println(alien.name)
      println(alien.greeting)

      meet(alien)

      println(alien.name.hashCode)
  }

}
