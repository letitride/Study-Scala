sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree

object BinaryTree {

  def max(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) =>
      v
    case Branch(v, Empty, r) =>
      val x = max(r)
      if(v > x) v else x
    case Branch(v, l, Empty) =>
      val x = max(l)
      if(v > x) v else x
    case Branch(v, l, r) =>
      val x = max(l)
      val y = max(r)
      if(v > x) {
        if(v > y) v else y
      } else {
        if(x > y) x else y
      }
    case Empty =>
      throw new RuntimeException
  }


  def min(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) =>
      v
    case Branch(v, Empty, r) =>
      val x = min(r)
      if(v < x) v else x
    case Branch(v, l, Empty) =>
      val x = min(l)
      if(v < x) v else x
    case Branch(v, l, r) =>
      val x = min(l)
      val y = min(r)
      if(v < x) {
        if(v < y) v else y
      } else {
        if(x < y) x else y
      }
    case Empty =>
      throw new RuntimeException
  }

  def depth(t: Tree): Int = t match {
    case Empty => 0
    case Branch(_, l, r) =>
      val ldepth = depth(l)
      val rdepth = depth(r)
      (if(ldepth < rdepth) rdepth else ldepth) + 1
  }
}