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
