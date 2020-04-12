import java.util.concurrent.{Callable, Executors}
import java.util.concurrent.atomic.AtomicInteger

object ExecutorServiceStudy extends App{
  val es = Executors.newFixedThreadPool(10)
  val counter = new AtomicInteger(0)

  val futures = for(i <- 1 to 1000) yield {
    es.submit(new Callable[Int] {
      override def call(): Int = {
        val count = counter.incrementAndGet()
        println(count)
        Thread.sleep(1000)
        count
      }
    })
  }

  println("sum: " + futures.foldLeft(0)((acc, f)=> acc + f.get()))
  es.shutdownNow()

}
