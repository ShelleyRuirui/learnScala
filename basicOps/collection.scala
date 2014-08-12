println("Test array")
val greetStrings=new Array[String](3)
greetStrings(0)="Hello" //greetStrings.update(0,"Hello")
greetStrings(1)=","
greetStrings(2)="Ruirui"

for (i <- 0 to 2)
  print(greetStrings(i))

println()

println("----------------------")
println("Test list")
val oneTwo=List(1,2)
val threeFour=List(3,4)
val oneTwoThreeFour=oneTwo:::threeFour
println(""+oneTwo+" and "+ threeFour+" were not mutated")
println("Thus,"+oneTwoThreeFour+" is a new list")

val twoThree=List(2,3)
val oneTwoThree=1::twoThree
println("one added to two three:"+oneTwoThree)

val newOneTwoThree=1::2::3::4::Nil
println("list created from element:"+newOneTwoThree)
println("######################")
val thrill="Will"::"fill"::"until"::Nil
val count=thrill.count(s=>s.length==4)
println("Length 4 element count:"+count)

val afterDrop=thrill.drop(2)//Drop first 2 elements
println("After drop 2:"+afterDrop)

val exists=thrill.exists(s=>s=="until")
println("exists:"+exists)

val filter=thrill.filter(s=>s.length==4)
println("filter:"+filter)

val allEndsWith=thrill.forall(s=>s.endsWith("l"))
println("All ends with l:"+allEndsWith)

thrill.foreach(s=>print(s)+" ")
println()

println("---------------------")
println("Test tuple")
val pair=(99,"string")
println("first element:"+pair._1)
println("second element:"+pair._2)


println("---------------------")
println("Test set&map")
var jetSet=Set("Boeing","Airbus") //Can use HashSet
jetSet+="Lear" //Crete a new set. Can import scala.collection.mutable.Set
println("jetSet contains cessna:"+jetSet.contains("Cessna"))

import scala.collection.mutable.Map
val treasureMap=Map[Int,String]()
treasureMap+=(1 -> "Go to island")
treasureMap+=(2 -> "Find big X on ground")
treasureMap+=(3 -> "Dig.")
println("treasureMap step 2:"+treasureMap(2))

val romanNumeral=Map(
  1->"I",
  2->"II",
  3->"III",
  4->"IV"
)
println("number map:"+romanNumeral)

//Test map on list
val l=List(1,2,3,4)
println(l.map(x=>x*2))

def f(x:Int)=if(x>2) Some(x) else None

println(l.map(x=>f(x)))

def g(v:Int)=List(v-1,v,v+1)
println(l.map(x=>g(x)))

println(l.flatMap(x=>g(x)))

//Test map on map
//import scala.collection.immutable.Map
println("----------------------")
val m=scala.collection.immutable.Map(1->2,2->4,3->6)
println("Map of map:"+m.map(v=>v._2))

println(m.mapValues(v=>v*2))
println(m.mapValues(v=>f(v)))

println(m.flatMap(e=>List(e._2)))
println(m.flatMap(e=>List(e)))

def h(k:Int,v:Int)=if(v>2) Some(k->v) else None

println(m.flatMap(e=>h(e._1,e._2)))
println(m.flatMap{case (k,v)=>h(k,v)})

m.filter(e=>f(e._2)!=None)
println(m.filter{case (k,v) => f(v)!=None})
println(m.filter{case (k,v) => f(v).isDefined})

//test foldLeft
def sum(list:List[Int]):Int=list.foldLeft(0)(_+_) //0 is the init result val
val fl=List(1,2,3)
println("list sum fold left:"+sum(fl))

def average(list:List[Double]):Double=list match{
  case head::tail => tail.foldLeft( (head,1.0) )((r,c) =>((r._1 + (c/r._2)) * r._2 / (r._2+1), r._2+1) )._1
  case Nil=> -1
}

val dfl=List(1.0,2.0,3.0)
println("list average fold left:"+average(dfl))

val fm=Map("first"->1,"second"->2)
println(fm.foldLeft(0){case (a,(k,v))=>a+v})

val abc=List("A","B","C")
def add(res:String,x:String)={
  println("op: $res + $x = ${res + x}")
  res+x
}
abc.reduceLeft(add)

//Test groupby
val cats=List("Tiger","Puma","Lion","Leopard","Bobcat")
val groupByLength=cats.groupBy(_.length) //List->Map(key->List)
println(groupByLength)

//Test reduce
val fruits=List("apple","apple","orange","mango","mango grape")
val word = fruits.flatMap(_.split(" "))
val m22 = word.map(word => (word,1)).groupBy(_._1)
val reduce1 = m22.map(word => (word._1,word._2.foldLeft(0)((sum,c) => sum+ c._2)))
println(m22)
println(reduce1)

val reduce = m22.map(word => (word._1,word._2.map(_=>1).reduce(_+_)))
println(reduce)


