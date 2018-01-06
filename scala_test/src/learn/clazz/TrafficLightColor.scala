package learn.clazz

object TrafficLightColor extends Enumeration{

  val RED,YELLOW,GREEN = Value
  val BLUE = Value(3,"blue")

  def main(args: Array[String]): Unit = {
    println(TrafficLightColor.RED.id+":"+TrafficLightColor.RED)
    println(TrafficLightColor.BLUE.id+":"+TrafficLightColor.BLUE)

    val valName = if(TrafficLightColor.RED == RED) "yes" else "no"
    println(valName)

    for(c <- TrafficLightColor.values) println(c.id+":"+c)

    //　根据id 与　name来进行查找定位
    println(TrafficLightColor(1)) // 将调用Enumeration.apply
    println(TrafficLightColor.withName("blue"))
  }
}
