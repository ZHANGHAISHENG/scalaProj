package learn.Future


import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * 使用future实现：
  * 过程：
  1：研磨所需的咖啡豆
  2：加热一些水
  3：用研磨好的咖啡豆和热水制做一杯咖啡
  4：打奶泡
  5：结合咖啡和奶泡做成卡布奇诺
  */
object CappuccinoMaker2 {

    type CoffeeBeans = String    //类型别名：咖啡豆
    type GroundCoffee = String   //类型别名：研磨好的咖啡豆
    case class Water(temperature: Int) //样例类：水
    type Milk = String         //类型别名：牛奶
    type FrothedMilk = String  //类型别名：奶泡
    type Espresso = String     //类型别名：咖啡（研磨好的咖啡豆和热水制作）
    type Cappuccino = String   //类型别名：卡布奇诺(咖啡和奶泡制作)


    //异常样例类
    case class GrindingException(msg: String) extends Exception(msg)
    case class FrothingException(msg: String) extends Exception(msg)
    case class WaterBoilingException(msg: String) extends Exception(msg)
    case class BrewingException(msg: String) extends Exception(msg)


    // 执行步骤
    //1：研磨所需的咖啡豆
    def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future{
      println("start grinding...")
      Thread.sleep(Random.nextInt(2000))
      if(beans == "baked beans") throw  GrindingException("are you joking?")
      println("finished grinding...")
      "ground coffee of $beans"
    }

    //2：加热一些水
    def heatWater(water: Water): Future[Water] = Future {
      println("heating the water now")
      Thread.sleep(Random.nextInt(2000))
      println("hot, it's hot!")
      water.copy(85)
    }
    //3：用研磨好的咖啡豆和热水制做一杯咖啡
    def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
      println("happy brewing :)")
      Thread.sleep(Random.nextInt(2000))
      println("it's brewed!")
      "espresso"
    }
    //4：打奶泡
    def frothMilk(milk: Milk):Future[FrothedMilk] = Future {
      println("milk frothing system engaged!")
      Thread.sleep(Random.nextInt(2000))
      println("shutting down milk frothing system")
      s"frothed $milk"
    }
    //5：结合咖啡和奶泡做成卡布奇诺
    def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"

    //判断温度是否合适
    def temperatureOkay2(water:Water): Future[Boolean] = Future {
      (80 to 85) contains(water.temperature)
    }

    //组合所有的步骤：使用for
    def prepareCappuccino():Future[Cappuccino] = {
      val groundCoffee = grind("arabica beans")
      val heatedWater = heatWater(Water(20))
      val frothedMilk = frothMilk("milk")
      for{
        ground <- groundCoffee
        water <- heatedWater
        foam <- frothedMilk
        espresso <- brew(ground,water) //等待其他三个运行完成
      } yield combine(espresso,foam)
    }

    def main(args: Array[String]): Unit = {
       println("start...")
       grind("arabica beans").onComplete{
         case Success(ground)=> println("got my $ground")
         case Failure(ex)=> println("This grinder needs a replacement, seriously!")
       }
      Thread.sleep(2000)
      println("end...")

      /**map**/
      val temperatureOkay1: Future[Boolean] = heatWater(Water(25)) map {
        water =>
        println("we`ar in the future")
        (80 to 85) contains(water.temperature)
      }
      Thread.sleep(2000)
      println(temperatureOkay1)//Future(Success(true))


      val netstedFuture: Future[Future[Boolean]] = heatWater(Water(25)) map{
        water => temperatureOkay2(water)
      }
      Thread.sleep(2000)
      println(netstedFuture)//Future(Success(Future(Success(true))))


      /**flatMap**/
      val flatFuture: Future[Boolean] = heatWater(Water(25)) flatMap {
        water => temperatureOkay2(water)
      }
      Thread.sleep(2000)
      println(flatFuture)//Future(Success(true))

      /**for 语句只不过是 flatMap 嵌套调用的语法糖**/
      val acceptable: Future[Boolean] = for{
        heatedWater <- heatWater(Water(25))
        okay <- temperatureOkay2(heatedWater)
      } yield okay
      Thread.sleep(2000)
      println(acceptable)//Future(Success(true))

      val result = prepareCappuccino()
      Thread.sleep(3000)
      println(result)//Future(Success(cappuccino))


  }

}
