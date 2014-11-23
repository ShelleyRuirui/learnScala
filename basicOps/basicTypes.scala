println(42 equals 42) //true
println(1 until 5)
println(1 to 5)

def isEqual(x:Int,y:Int) = x==y
println(isEqual(1,1)) //true

def isEqual(x:Any,y:Any) = x==y
println(isEqual(1,1))

val x = "abcd".substring(2)
val y = "abcd".substring(2)
println(x==y) //true like equals method for Java
println(x eq y)  //false  for AnyRef like == in Java comparing references

//String
println(
  """Test
    |To see
    |If it works
  """.stripMargin)

//' is needed as yield is a keyword in scala
Thread.`yield`()