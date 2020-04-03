abstract class Show {
  def show: String
}

//T1, T2はShowを継承したクラス
class ShowablePair[T1 <: Show, T2 <: Show](val t1:T1, val t2:T2) extends Show {
  def show:String = "(" + t1.show + "" + t2.show + ")"
}
/*
scala> class StringShow(str: String) extends Show { override def show: String = str }
defined class StringShow
scala> new ShowablePair[StringShow, StringShow](new StringShow("a"), new StringShow("b"))
res0: ShowablePair[StringShow,StringShow] = ShowablePair@3ad847f8¥
scala> res0.show
res1: String = (ab)
 */
