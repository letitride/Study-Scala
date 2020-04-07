
object CheckThenAct extends App{
  for(i <- 1 to 100){
    new Thread(()=> println(SingletonProvider.getObject)).start()
  }
}

object SingletonProvider{
  private [this] var singleton: BigObject = null

  /** synchronized */
  def get: BigObject = this.synchronized{
    if(singleton == null){
      singleton = new BigObject()
    }
    singleton
  }

  /** lazy */
  lazy val getObject = new BigObject()
}

class BigObject(){
  Thread.sleep(1000)
}
