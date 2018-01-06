package learn.seq

object SeqTest3 {

  trait User {
    def name: String
    def score: Int
  }
  class FreeUser(
    val name: String,
    val score: Int,
    val upgradeProbability: Double
  ) extends User

  object premiumCandidate {
    def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
  }
  def main(args: Array[String]): Unit = {

    val user: User = new FreeUser("Daniel", 2500, 0.8d)
    user match {
      case freeUser @ premiumCandidate() =>  println(freeUser.name)
      case _ => println("failed")
    }
  }

}
