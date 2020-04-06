import scala.reflect.runtime.universe._

object ReflectionStudy extends App{

  println("========= from class =========")
  println(typeTag[Option[_]].tpe.decls)
}
