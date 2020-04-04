import scala.util.Try

sealed trait LoginError

case object InvalidPassword extends LoginError
case object UserNotFound extends LoginError
case object PasswordLocked extends LoginError

case class User(id: Long, name: String, password: String)

object LoginService {
  val mUser = "taro"
  val mPassword = "Password1"

  def login(name: String, password: String): Either[LoginError, User] = {
    (name, password) match {
      case (mUser, mPassword) => Right(User(1, name, password))
      case (mUser, _) => Left(InvalidPassword)
      case (_, _) => Left(UserNotFound)
    }
  }

  def createString(size: Int): Try[String] = {
    Try{
      require(size >= 0, "sizeはゼロ以上である必要があります")
      (for (i <- 0 to size) yield "a").mkString
    }
  }

}
/*
scala> LoginService.login("taro", "Password1") match {
     | case Right(user) => println(s"id: ${user.id}")
     | case Left(InvalidPassword) => println(s"Invalid Password")
     | }
 */