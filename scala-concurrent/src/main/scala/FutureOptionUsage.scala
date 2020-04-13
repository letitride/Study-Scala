import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object FutureOptionUsage extends App{

  val random = new Random()
  val waitMaxMilliSec = 3000

  val futureMilliSec: Future[Int] = Future{
    val waitMilliSec = random.nextInt(waitMaxMilliSec)
    if(waitMilliSec < 1000) throw  new RuntimeException(s"waitMilliSec is ${waitMilliSec}")
    Thread.sleep(waitMilliSec)
    waitMilliSec
  }

  val futureSec: Future[Double] = futureMilliSec.map(i => i.toDouble / 1000)
  futureSec onComplete{
    case Success(waitSec) => println(s"Success ${waitSec} sec")
    case Failure(t) => println(s"Failure: ${t.getMessage}")
  }

  Thread.sleep(3000)
}
