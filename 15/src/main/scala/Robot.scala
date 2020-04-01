trait Greeter{
  def greet(): Unit
}

trait Robot {
  //mix inされるtraitの宣言
  self: Greeter =>

  def start(): Unit = greet()
  override final def toString = "Robot"
}

trait HelloGreeter extends Greeter {
  def greet(): Unit = println("Hello!")
}
//実装の注入
//val r: Robot = new Robot with HelloGreeter
//r.start()