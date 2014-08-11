abstract class Element{
  def contents: Array[String]  //can change def to val
  def height:Int=contents.length
  def width:Int=if(height==0) 0 else contents(0).length
  def demo(){
    println("Element's impl")
  }
}

class ArrayElement(conts:Array[String]) extends Element{
  def contents:Array[String]=conts  //Can use val contents:Array[String] to implement the method
  override def demo(){
    println("ArrayElement's impl")
  }
}

class ArrayElement2(val contents:Array[String]) extends Element

var ae=new ArrayElement(Array("hello","ruirui"))
println(ae.width)

val ae2=new ArrayElement2(Array("cool"))
println(ae2.contents)

class Cat{
  val dangerous=false
}

class Tiger(override val dangerous:Boolean, private var age:Int) extends Cat

println(new Tiger(true,3).dangerous)



class LineElement(s:String) extends ArrayElement(Array(s)){
  override def width=s.length  //override is a must to override non abstract method in parent
  override def height=1
  override def demo(){
    println("LineElement's impl")
  }
}

ae=new LineElement("abc") 
println("width:"+ae.width+" height:"+ae.height)

//can add final to class and methods
class UniformElement(ch:Char,override val width:Int,override val height:Int) extends Element{
  private val line=ch.toString*width
  def contents=Array.fill(height){line}
  override def demo(){
    println("UniformElement's impl")
  }
}

val ue=new UniformElement('*',4,5)
ue.contents.foreach(s=>println(s))

//Try polymorphism
def invokeDemo(e:Element){
  e.demo()
}

invokeDemo(ue)

