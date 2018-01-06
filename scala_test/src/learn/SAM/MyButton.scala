package learn.SAM

class MyButton {
  var eventListener: MyEventListener = null

  def addActionListener(eventListener: MyEventListener) {
    this.eventListener = eventListener
  }

  def click() {
    if (eventListener != null) eventListener.actionPerFormed(new MyActionEvent("click"))
    else println("未添加事件监听器")
  }

}


