package learn.Future

import scala.util.Try

/**
  * 普通方式实现
  * 过程：
  1：研磨所需的咖啡豆
  2：加热一些水
  3：用研磨好的咖啡豆和热水制做一杯咖啡
  4：打奶泡
  5：结合咖啡和奶泡做成卡布奇诺
  */
object CappuccinoMaker {

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
    def grind(beans: CoffeeBeans): GroundCoffee = "ground coffee of $beans"//1：研磨所需的咖啡豆
    def heatWater(water: Water): Water = water.copy(85) //2：加热一些水
    def brew(coffee: GroundCoffee, heatedWater: Water): Espresso = "espresso"//3：用研磨好的咖啡豆和热水制做一杯咖啡
    def frothMilk(milk: Milk): FrothedMilk = "frothed $milk"//4：打奶泡
    def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"//5：结合咖啡和奶泡做成卡布奇诺

    // 组合所有的步骤并执行
    def prepareCappuccino(): Try[Cappuccino] = for {
      ground <- Try(grind("arabica beans"))
      water <- Try(heatWater(Water(25)))
      espresso <- Try(brew(ground, water))
      foam <- Try(frothMilk("milk"))
    } yield combine(espresso, foam)

    def main(args: Array[String]): Unit = {
      val r = prepareCappuccino() //Success(cappuccino)
      println(r)
  }

}
