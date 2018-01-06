package learn.Future

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global


object PromiseTest {

  case class TaxCut(reduction: Int)

  //税收样例类
  case class LameExcuse(msg: String) extends Exception(msg)

  //违背诺言样例类
  //减税函数
  def redeemCampaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(1000)
      //p.success(TaxCut(20))
      p.failure(LameExcuse("global economy crisis"))
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }

  def main(args: Array[String]): Unit = {
    val taxCutF: Future[TaxCut] = redeemCampaignPledge()
    println("start...")
    taxCutF.onComplete {
      case Success(TaxCut(reduction)) =>
        println("A miracle! They really cut our taxes by " + reduction + " percentage points!")
      case Failure(ex) =>
        println("They broke their promises! Again! Because of a " + ex.getMessage)
    }
    println("end...")
    Thread.sleep(2000)
    println(taxCutF) //Future(Success(TaxCut(20)))
  }

}
