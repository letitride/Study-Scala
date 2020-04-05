object TypeClassStudy {

  trait Additive[A]{
    def plus(a: A, b:A): A
    def zero: A
  }

  case class Rational(num: Int, den: Int)

  object Rational{

    implicit object RationalAdditive extends  Additive[Rational]{
      override def plus(a: Rational, b: Rational): Rational = {
        if(a == zero){
          b
        }else if(b == zero){
          a
        }else{
          Rational(a.num * b.den + b.num * a.den, a.den * b.den)
        }
      }

      override def zero: Rational = Rational(0, 0)
    }
  }

  def sum[A](list: List[A])(implicit m: Additive[A]): A = list.foldLeft(m.zero)((x,y)=>m.plus(x, y))
}
