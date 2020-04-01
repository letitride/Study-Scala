trait Greeter2{
  def greet(): Unit
}
trait Robot2 extends Greeter2 {
  def start(): Unit = greet()
  override final def toString = "Robot2"
}
trait HelloGreeter2 extends Greeter2 {
  def greet(): Unit = println("Hello!")
}
//この場合は継承関係
//val r2 :Robot2 = new Robot2 with HelloGreeter2
//r2.start()
// mixin したtraitにもアクセスできる
//r2.greet()