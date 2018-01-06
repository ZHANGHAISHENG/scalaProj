package learn.option

object optionTest1 {

  case class User(
                   id: Int,
                   firstName: String,
                   lastName: String,
                   age: Int,
                   gender: Option[String]
                 )

  object UserRepository {
    private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")), 2 -> User(2, "Johanna", "Doe", 30, None))
    def findById(id: Int): Option[User] = users.get(id)
    def findAll = users.values
  }

  def main(args: Array[String]): Unit = {
    val user1 = UserRepository.findById(1)
    /**isDefined**/
    if(user1.isDefined){
      println(user1.get.firstName)
    }

    /**foreach**/
    //如果是 None ，那它就不会被调用
    user1.foreach(user => println(user.firstName))

    /**map**/
    val a1 = user1.map(_.gender) // Some(Some(male))
    println(a1)

    /**flatMap**/
    val a2 = user1.flatMap(_.gender)
    println(a2) // Some(male)

    /**filter**/
    val a3 = user1.filter(_.age > 30)
    println(a3) // Some(User(1,John,Doe,32,Some(male)))

    /**在生成器左侧使用**/
    //可以排除Nome
    val a4 = for {
      User(_, _, _, _, Some(gender)) <- UserRepository.findAll
    } yield gender
    println(a4) // List(male)

    /**链接 Option: getOrElse**/
    case class Resource(content: String)
    val resourceFromConfigDir: Option[Resource] = None
    val resourceFromClasspath: Option[Resource] = Some(Resource("I was found on the classpath"))
    val resource = resourceFromConfigDir orElse resourceFromClasspath
    println(resource)
    println(resourceFromConfigDir.getOrElse(resourceFromClasspath))

  }

}
