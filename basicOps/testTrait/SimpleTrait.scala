package testTrait

/**
 * Created by luruirui on 14-11-25.
 */

trait Philosophical{
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString = "green"
  override def philosophize() {
    println("It ain't easy being "+ toString +"!")
  }
}

class Animal

class Frog2 extends Animal with Philosophical {
  override def toString = "green"
}

object SimpleTrait {

  def main(args: Array[String]) {
    val frog=new Frog
    frog.philosophize()
    val phil:Philosophical=frog
    phil.philosophize()
  }
}
