//Tのスーパークラスでも型マッチするようにする val s:Stack[AnyVal] = Stack[Int]()
trait Stack[+T] {

  def pop: (T, Stack[T])

  //[E >: T]  EはTのスーパークラス　この定義がないと[+T]の制約の不整合となる
  def push[E >: T](e: E): Stack[E]

  def isEmpty: Boolean

}

class NonEmptyStack[+T](private val top: T, private val rest: Stack[T]) extends Stack[T] {

  def push[E >: T](e: E): Stack[E] = new NonEmptyStack[E](e, this)

  def pop = (top, rest)

  def isEmpty = false
}

//Nothingはすべての型のサブクラス
case object EmptyStack extends Stack[Nothing] {
  def pop: Nothing = throw new IllegalArgumentException("empty stack")

  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)

  def isEmpty = true

}

object Stack{
  def apply(): Stack[Nothing] = EmptyStack
}
/*
scala> Stack().push(1)
res0: Stack[Int] = NonEmptyStack@374c3975
scala> res0.push(2)
res1: Stack[Int] = NonEmptyStack@266da047
scala> res1.push(3)
res2: Stack[Int] = NonEmptyStack@fd87c22
scala> res2.pop
res3: (Int, Stack[Int]) = (3,NonEmptyStack@266da047)
scala> res3._2.pop
res4: (Int, Stack[Int]) = (2,NonEmptyStack@374c3975)

scala> val (top, rest): (AnyVal, Stack[AnyVal]) = res4
top: AnyVal = 2
rest: Stack[AnyVal] = NonEmptyStack@374c3975
*/

class Container[+T](n: T) {
  def put[E >: T](a: E) = new Container[E](a)
  def get(): T = n
}