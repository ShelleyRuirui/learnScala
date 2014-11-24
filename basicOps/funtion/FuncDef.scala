package funtion

import scala.collection.JavaConverters._

/**
 * Created by luruirui on 14-11-23.
 */
object FuncDef {

  //type cannot be omitted here
  def add1=(_:Int)+(_:Int)

  def sum1(a:Int,b:Int,c:Int)=a+b+c

  def sum2=sum1 _

  def sum3=sum1(1,_:Int,3)

  def echo(args:String*)=
    for(arg<-args)
      println(arg)

  def plainOldSum(a:Int,b:Int)=a+b

  def curriedSum(x:Int)(y:Int)=x+y

  def first(x:Int)=(y:Int)=>x+y

  val second=first(1)

  val onePlus=curriedSum(1)_

  def main(args: Array[String]): Unit = {
    println(add1(1,2))
    println(sum2(1,2,3))
    println(sum3(2))
    echo()

    val array=Array[String]("a","b","c")
    echo(array:_*)

    println(plainOldSum(1,2))
    println(curriedSum(3)(4))
    println(first(2)(3))
    println(second(2))
    println(onePlus(5))
  }
}
