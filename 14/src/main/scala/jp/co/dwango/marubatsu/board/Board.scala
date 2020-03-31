package jp.co.dwango.marubatsu.board

//marubatsu package内のみ使用可能
private[marubatsu] class Board(val cells:Map[(Int, Int), CellState], val next: CellState) {

  private[marubatsu] def put(row: Int, column: Int): Board = {
    new Board(cells + ((row, column) -> next), getNext(next))
  }

  //privateだけではこの必ずしもこのインスタンス内からのアクセスに制限できないため、private[this]とする
  private[this] def getNext(current: CellState): CellState = {
    current match {
      case Empty => Empty
      case Maru => Batsu
      case Batsu => Maru
    }
  }

  def canPut(row: Int, column: Int): Boolean = {
    cells((row, column)) == Empty
  }

  override def toString() = s"Board($cells, $next)"
}

object Board {

  def apply(): Board = {
    //Seq
    val keyValues = for(row <- 0 to 2; column <- 0 to 2) yield (row, column) -> Empty
    //Seq to Map
    new Board(keyValues.toMap, Maru)
  }
}
