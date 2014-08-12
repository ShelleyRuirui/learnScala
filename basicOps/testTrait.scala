trait Philosophical{
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

class Animal
trait HasLegs  //Cannot have class parameters; super call dynamically bind

//class Frog extends Philosophical{
//  override def toString="green"
//}

class Frog extends Animal with Philosophical with HasLegs{
  override def toString="frog"
  override def philosophize(){
    println("It ain't easy being "+ toString +"!")
  }
}

//val frog=new Philosophical
val frog=new Frog

frog.philosophize()

class Point(val x:Int, val y:Int)

trait Rectangular{
  def topLeft:Point
  def bottomRight:Point
  def left=topLeft.x
  def right=bottomRight.x
  def width=right-left
}

abstract class Component extends Rectangular{
}

class Rectangle(val topLeft:Point,val bottomRight:Point) extends Rectangular{
}

val rect=new Rectangle(new Point(1,1),new Point(10,10))
println(rect.left)
println(rect.right)
println(rect.width)

class Rational(n:Int,d:Int) extends Ordered[Rational]{
  val numer=n
  val denom=d
  def compare(that:Rational)=
    (this.numer*that.denom-this.denom*that.numer)
  
}


//Test stacking of traits
abstract class IntQueue{
  def get(): Int
  def put(x:Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

val queue=new BasicIntQueue

queue.put(10)
queue.put(20)
println(queue.get())

trait Doubling extends IntQueue{
  abstract override def put(x:Int){
    super.put(2*x)
  }
}
