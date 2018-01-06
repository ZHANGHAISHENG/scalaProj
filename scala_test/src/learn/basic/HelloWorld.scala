package learn.basic

import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

object HelloWorld {
  /* 这是我的第一个 Scala 程序
   * 以下程序将输出'Hello World!'
   */
  def main(args: Array[String]) {
    println("Hello, world!hell") // 输出 Hello World
/*
    val command = ArrayBuffer("a","b","c")
    // val pd = new ProcessBuilder(command)

    val map = Map("alice" -> 10,"Bob"  -> 3,"Cindy" -> 8) //不可变map,无法更新
    val map2 = Map(("alice" , 10),("Bob" , 3),("Cindy", 8)) //同上
    val map1 = scala.collection.mutable.Map("alice" -> 10,"Bob"  -> 3,"Cindy" -> 8)//可变map
    val map3 = new HashMap[String,Int]() //空map

    map.get("Bob")//不存在就报异常
    val value1 = if(map.contains("Bob")) map("Bob") else 0
    val value2 = map.getOrElse("Bob",0)
    map1("Bob") = 10 //修改
    map1 += ("Bob" -> 10,"Fred" -> 7) // 添加元素
    map1 -= "alice" //删除元素

    val newMap = map.updated("hi",20)//不可变map添加元素，产生新的map，没有就新增

    val sortedMap = scala.collection.immutable.SortedMap("alice" -> 10,"Bob"  -> 3,"Cindy" -> 8) //根据value升序，不可变map

    val linkedMap = scala.collection.mutable.LinkedHashMap("alice" -> 10,"Bob"  -> 3,"Cindy" -> 8)//根据添加的key排序不可变map
*/

  }
}