package classes

/**
 * Created by luruirui on 14-11-25.
 */

abstract class Element{
  def contents:Array[String]
  val height:Int=contents.length
  val width:Int=if(height==0) 0 else contents(0).length
  def demo(): Unit ={
    println("Element's demo")
  }

  def above(that:Element):Element=
    new ArrayElement(this.contents ++ that.contents)

  def beside(that:Element):Element={
    new ArrayElement(
      for{
        (line1,line2) <- this.contents zip that.contents
      }yield line1+line2
    )
  }

  override def toString=contents.mkString("\n")

}

class ArrayElement(conts:Array[String]) extends Element{
  //This def here can be changed to val
  def contents:Array[String]=conts
  override def demo(): Unit ={
    println("ArrayElement's demo")
  }
}

class ArrayElement2(val contents:Array[String]) extends Element

class LineElement(s:String) extends ArrayElement(Array(s)){
  override val width=s.length
  override val height=1
  override def demo():Unit={
    println("LineElement's demo")
  }
}

class Cat{
  val dangerous=false
}

class Tiger(
  override val dangerous:Boolean,
  private var age:Int) extends Cat

object Inheritence {
  def main(args: Array[String]) {
    val a1=new ArrayElement(Array("hey","you"))
    println("a1.width "+a1.width)

    val a2=new ArrayElement(Array("hi","go"))
    println("a2.width "+a2.width)

    val tiger=new Tiger(true,10)
    println(tiger.dangerous)

    def invokeDemo(e:Element):Unit={
      e.demo()
    }

    a1.demo()
  }
}
