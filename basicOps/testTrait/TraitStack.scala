package testTrait

/**
 * Created by luruirui on 14-11-25.
 */

abstract class IntQueue{
  def get(): Int
  def put(x:Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
  def mkString:String=buf.mkString(" ")
}

trait Doubling extends IntQueue{
  abstract override def put(x:Int){
    super.put(2*x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

object TraitStack {
  def main(args: Array[String]) {
    val queue=new BasicIntQueue
    queue.put(10)
    queue.put(20)
    println(queue.get())

    val myqueue=new MyQueue
    myqueue.put(10)
    println(myqueue.get())

    val newQueue=(new BasicIntQueue with Filtering with Incrementing)
//    val newQueue=(new BasicIntQueue with Incrementing with Filtering)
    newQueue.put(-1)
    newQueue.put(0)
    newQueue.put(1)
    println(newQueue.mkString)
  }
}
