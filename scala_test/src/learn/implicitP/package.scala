package learn

import java.io.File
import learn.implicitP.ImplicitTest.RichFile

package implicitP {

  import java.awt.Point

  import learn.implicitP.ImplicitTest.RichFileAnother

  object ImplicitConversion {
    //从Double类型转换到Int类型
    implicit def double2Int(x: Double) = x.toInt

    //隐式函数将java.io.File隐式转换为RichFile类
    implicit def file2RichFile(file: File) = new RichFile(file)

    implicit def richFile2RichFileAnother(richFile:RichFile) = new RichFileAnother(richFile)

  }

}
