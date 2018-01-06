package learn.SAM

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton


object SAMTest {

  /*implicit def makeAction(action: (ActionEvent) => Unit) = new ActionListener {
    override def actionPerformed(event: ActionEvent) = {action(event)}
  }
*/
  def main(args: Array[String]): Unit = {
      val button = new JButton("")
      var counter = 0
      /*button.addActionListener(new ActionListener {
        override def actionPerformed(actionEvent: ActionEvent) = counter += 1
      })*/
      // 效果同上，但需要提前定义 implicit def makeAction
      button.addActionListener((actionEvent: ActionEvent) => counter += 1)
      button.doClick()

  }
}
