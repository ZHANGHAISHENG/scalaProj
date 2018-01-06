package learn.trait4

import java.io.IOException

class SadException extends IOException with LoggerException {


}

object  SadException{
  def main(args: Array[String]): Unit = {
      println("初始化成功")
  }
}
