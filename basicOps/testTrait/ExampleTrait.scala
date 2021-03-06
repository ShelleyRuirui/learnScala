package testTrait

/**
 * Created by luruirui on 14-11-25.
 */

class Point(val x:Int,val y:Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // and many more geometric methods...
}

abstract class Component extends Rectangular{
  //other methods
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular{

}

object ExampleTrait {
  def main(args: Array[String]) {
    val rect=new Rectangle(new Point(1,1),new Point(3,3))
    println(rect.width)
  }
}
