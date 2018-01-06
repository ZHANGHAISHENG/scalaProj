package learn.Either

import java.net.URL

/**
  * 集合处理：黑名单例子
  */
object EitherTest2 {

  def main(args: Array[String]): Unit = {
    type Citizen = String
    case class BlackListedResource(url: URL, visitors: Set[Citizen])

    val blacklist = List(
      BlackListedResource(new URL("https://google.com"), Set("John Doe", "Johanna Doe")),
      BlackListedResource(new URL("http://yahoo.com"), Set.empty),
      BlackListedResource(new URL("https://maps.google.com"), Set("John Doe")),
      BlackListedResource(new URL("http://plus.google.com"), Set.empty)
    )

    val checkedBlacklist: List[Either[URL, Set[Citizen]]] = {
      blacklist.map(resource =>
        if (resource.visitors.isEmpty) Left(resource.url)
        else Right(resource.visitors))
    }

    val suspiciousResources = checkedBlacklist.flatMap(_.left.toOption)
    val problemCitizens = checkedBlacklist.flatMap(_.right.toOption).flatten.toSet

    println(suspiciousResources)

    println(problemCitizens)

  }

}
