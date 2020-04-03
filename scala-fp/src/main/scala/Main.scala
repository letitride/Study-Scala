import scala.annotation.tailrec

object Main {

  @tailrec
  def series(n: Int, acc: Int): Int = {
    if(n == 0){
      acc
    } else {
      //accumulatorに和を渡す
      series(n - 1, acc + n)
    }
  }

  @tailrec
  def fact(n: Int, acc: Int): Int = {
    if (n <= 1){
      acc
    } else {
      // 1  * 2 * 3
      fact(n - 1, n * acc)
    }
  }

  def toggle(switch: Switch): Switch = {
    new Switch( !switch.isOn )
  }

  //Main.twice((x)=>x*2)(3)
  def twice(f: Int => Int): Int => Int = {
    (x) => f(f(x))
    //f.compose(f)
  }

}

class Switch(var isOn: Boolean)

