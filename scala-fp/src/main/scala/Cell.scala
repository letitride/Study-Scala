class Cell[T](var value: T) {

  def put(newValue: T): Unit = {
    value = newValue
  }

  def get(): T = value

}
/*
scala> val cell = new Cell[Int](1)
cell: Cell[Int] = Cell@3f866f50
scala> cell.put(2)
scala> cell.get()
res1: Int = 2
scala> cell.put("something")
                ^
       error: type mismatch;
        found   : String("something")
        required: Int

scala> val cell2 = new Cell[String]("string")
cell2: Cell[String] = Cell@6f9a3325
scala> cell2.put("something")
scala> cell2.get()
res4: String = something
*/
