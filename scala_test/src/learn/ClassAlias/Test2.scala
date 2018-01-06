package learn.ClassAlias


object Test2 {
  case class Person(name:String,age:Int,income:Int)
  type People = List[Person]
  type PersonPredicate = Person => Boolean //类似C#的委托
  val teenagerPred:  PersonPredicate = person => person.age < 20
  val teenagerPred2:  PersonPredicate = _.age < 20 //同上
  val teenagerPred3: PersonPredicate = {person => person.age < 20}//同上
  val teenagerPred4: (Person) => Boolean = {person => person.age < 20}//同上

  //使用类型别名进行过滤
  def teenagers(people: People): People = {
    people.filter(teenagerPred)
  }

  //收税例子：
  type Tax = Person => Double

  val incomeTax: Tax = person => person.income * 5 / 100

  val kejuanzaTax: Tax = person => person.income * 20 / 100

  def calculateTax(person: Person, taxes: List[Tax]): Double = {
    taxes.foldLeft(0d) {
      (acc, curTax) => acc + curTax(person)
    }
  }

  def giveMeYourMoney(p: Person) = {
    calculateTax(p, List(incomeTax, kejuanzaTax))
  }


  def main(args: Array[String]): Unit = {



  }
}
