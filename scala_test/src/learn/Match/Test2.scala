package learn.Match

object Test2 {

  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) :: ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
  def wordsWithoutOutliers1(wordFrequencies: Seq[(String, Int)]): Seq[String] =
      wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)

  //模式匹配的匿名函数
  def wordsWithoutOutliers2(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.filter{ case(_,f) => f > 3 && f < 25 } map {case (w,_) => w}


  def main(args: Array[String]): Unit = {
    val a = wordsWithoutOutliers1(wordFrequencies) // List("habitual", "homely", "society")
    println(a)

    val pf = new PartialFunction[(String, Int), String] {
      def apply(wordFrequency: (String, Int)) = wordFrequency match {
        case (word, freq) if freq > 3 && freq < 25 => word
      }
      def isDefinedAt(wordFrequency: (String, Int)) = wordFrequency match {
        case (word, freq) if freq > 3 && freq < 25 => true
        case _ => false
      }
    }

    val b = pf.isDefinedAt(("hello",5))
    println(b) // true

  }

}
