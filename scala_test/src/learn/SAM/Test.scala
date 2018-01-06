package learn.SAM

object Test {

  implicit def makeAction(action: (MyActionEvent) => Unit) = new MyEventListener {
    override def actionPerFormed(event: MyActionEvent): Unit = action(event)
    override def actionPerFormed2(event: MyActionEvent): Unit = action(event)
  }

  def main(args: Array[String]): Unit = {
    val myButton = new MyButton()
    /*myButton.addActionListener(new MyEventListener() {
       override def actionPerFormed(event:MyActionEvent): Unit = println(event.getMsg())
    })*/

    myButton.addActionListener((event: MyActionEvent) => println(event.getMsg()))
    myButton.click() // click

  }
}
