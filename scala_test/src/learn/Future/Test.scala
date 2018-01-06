package learn.Future

import java.util.concurrent.{ArrayBlockingQueue, ThreadPoolExecutor, TimeUnit}
import scala.concurrent.ExecutionContext

object Test {

  def main(args: Array[String]): Unit = {
    val executorService = new ThreadPoolExecutor(10, 30, 30, TimeUnit.MINUTES, new ArrayBlockingQueue[Runnable]( 10))
    implicit  val executor = ExecutionContext.fromExecutorService(executorService)
  }

}
