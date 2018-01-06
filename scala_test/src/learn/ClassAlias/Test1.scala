package learn.ClassAlias

import learn.HightType.Test1.Email

object Test1 {

  case class Person(name:String,age:Int,income:Int)
  case class Email(
                    subject: String,
                    text: String,
                    sender: String,
                    recipient: String
                  )
  def main(args: Array[String]): Unit = {

    type People = List[Person]
    type PersonPredicate = Person => Boolean
    val teenagerPred:  PersonPredicate = person => person.age < 20
    val teenagerPred2:  PersonPredicate = _.age < 20
    val teenagerPred3: PersonPredicate = {person => person.age < 20}
    val teenagerPred4: (Person) => Boolean = {person => person.age < 20}
    //使用类型别名进行过滤
    def teenagers(people: People): People = {
      people.filter(teenagerPred)
    }




    //收税例子：
    type Tax = Person => Double

    val incomeTax: Tax = person => person.income * 5 / 100

    val kejuanzaTax: Tax = person => person.income * 20 / 100

    def giveMeYourMoney(p: Person) = {
      calculateTax(p, List(incomeTax, kejuanzaTax))
    }

    def calculateTax(person: Person, taxes: List[Tax]): Double = {
      taxes.foldLeft(0d) {
        (acc, curTax) => acc + curTax(person)
      }
    }



    //=============================================
    type EmailFilter = Email => Boolean //类型别名
    val sentByOneOf1: Set[String] => EmailFilter ={
      senders =>
        email => senders.contains(email.sender)
    }

    //这样就省去了使用循环来判断true 或 false
    val sentByOneOf2: (Set[String]) => (Email => Boolean) ={
      senders =>
        email => senders.contains(email.sender)
    }

    val minimumSize: Int => EmailFilter =
      n =>
        email => email.text.size >= n
    val maximumSize: Int => EmailFilter =
      n =>
        email => email.text.size <= n


    //高阶函数 - 重用已有函数
    type SizeChecker = Int => Boolean
    val sizeConstraint: SizeChecker => EmailFilter =
      f =>
        email => f(email.text.size)

    val maximumSize1: Int => EmailFilter =
      n =>
        email => email.text.size <= n

    val maximumSize2: Int => EmailFilter =
      n =>
        sizeConstraint(_ <= n)

    //sizeConstraint(Email("","","","") <= 20)
    println("hello:"+minimumSize(1)(Email("","","","")))
    println("hello:"+sizeConstraint(_ < 20)(Email("","","","")))


    //高阶函数：函数组合 - andThen
    val sentByOneOf: Set[String] => EmailFilter =
      senders =>
        email => senders.contains(email.sender)

    val notSentByAnyOf: Set[String] => EmailFilter =
      senders =>
        email => !senders.contains(email.sender)

    //同上
    def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a) //取反

    val notSentByAnyOf1 = sentByOneOf andThen (g => complement(g))

    val notSentByAnyOf2 = sentByOneOf andThen (complement(_))






    /*type EmailFilter = Email => Boolean
    val sentByOneOf: Set[String] => EmailFilter =
      senders =>
        email => senders.contains(email.sender)

*/

    //高阶函数：谓词组合
    //实现多个过滤
    def any[A](predicates: (A => Boolean)*): A => Boolean = a => predicates.exists(pred => pred(a))
    def none[A](predicates: (A => Boolean)*) = complement(any(predicates: _*))
    def every[A](predicates: (A => Boolean)*) = none(predicates.view.map(complement(_)): _*)

    val filter: EmailFilter = every(
      notSentByAnyOf(Set("johndoe@example.com")),
      minimumSize(100),
      maximumSize(10000)
    )



    //高阶函数：流水线组合
    val addMissingSubject = (email: Email) =>
      if (email.subject.isEmpty) email.copy(subject = "No subject")
      else email
    val checkSpelling = (email: Email) =>
      email.copy(text = email.text.replaceAll("your", "you're"))
    val removeInappropriateLanguage = (email: Email) =>
      email.copy(text = email.text.replaceAll("dynamic typing", "**CENSORED**"))
    val addAdvertismentToFooter = (email: Email) =>
      email.copy(text = email.text + "\nThis mail sent via Super Awesome Free Mail")


    val pipeline = Function.chain(Seq(
      addMissingSubject,
      checkSpelling,
      removeInappropriateLanguage,
      addAdvertismentToFooter))

    val mails = Email(
      subject = "It's me again, your stalker friend!",
      text = "Hello my friend! How are you?",
      sender = "johndoe@example.com",
      recipient = "me@example.com") :: Nil




  }

}
