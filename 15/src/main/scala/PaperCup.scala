trait Fillable{
  def fill(): Unit = printf("Fill!")
}

trait Disposable {
  def dispose(): Unit = println("Dispose!")
}

//traitのインスタンス化
//val f = new Fillable(){}

class Pager

class PaperCup extends Pager with Fillable with Disposable

trait TraitA{
  def greet(): Unit
}
trait TraitB extends TraitA{
  def greet(): Unit = println("Good morning")
}
trait TraitC extends TraitA{
  def greet(): Unit = println("Good evening")
}
class Class1 extends TraitB with TraitC{
  override def greet(): Unit = println("How are you?")
}
class Class2 extends TraitB with TraitC{
  override def greet(): Unit = super[TraitB].greet()
}
class Class3 extends TraitB with TraitC {
  override def greet(): Unit = {
    super[TraitB].greet()
    super[TraitC].greet()
  }
}

trait TraitAA{
  def greet(): Unit = println("Hello")
}
trait TraitBB extends TraitAA{
  override def greet(): Unit = println("Good morning")
}
trait TraitCC extends TraitAA{
  override def greet(): Unit = println("Good evening")
}
trait TraitDD extends TraitAA{
  override def greet(): Unit = {
    println("TraitDD")
    super.greet()
  }
}
//線形化 trait側のメソッドをoverride宣言することで継承が線形化できる
class Class4 extends TraitBB with TraitCC

// TraitDD good morning
class Class5 extends TraitBB with TraitDD

// good morning
class Class6 extends TraitDD with TraitBB