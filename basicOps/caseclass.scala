abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String, arg:Expr) extends Expr
case class BinOp(operator:String, left:Expr, right:Expr) extends Expr

def simplifyTop(expr:Expr):Expr = expr match {
  case UnOp("-",UnOp("-",e)) => e
  case BinOp("+",e,Number(0)) => e
  case BinOp("*",e,Number(1)) => e
  case _ => expr
}

def judgeIsBinary(expr:Expr):Unit=expr match{
  case BinOp(op,_,_) =>
    println(expr+" is a binary operation")
  case _ =>
}

val e=Var("x")
println(simplifyTop(UnOp("-",UnOp("-",e))))

val e2=new UnOp("-",new UnOp("-",e))
println(simplifyTop(e2))

def describe(x:Any)=x match {
  case 5 => "five"
  case true => "true"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

println(describe(5))
println(describe(Nil))
println(describe(List(1,2,3)))

//Constant pattern
import Math.{E,Pi}
val Eres=E match {
  case Pi => "strange math?Pi="+Pi
  case _=> "OK"
}
println(Eres)

//Variable pattern
val Eres2=E match {
  case pi => "strange math?Pi="+pi
}
println(Eres2)

//Tranfer pi to constant
val pi=Math.Pi
val Eres3=E match {
  case `pi` => "strange math?Pi="+pi
  case _ => "OK"
}
println(Eres3)

//sequence pattern
val list1=List(0,1,2)
list1 match {
  //List(0,_*) => xxx
  case List(0,_,_) => println("found it")
  case _ =>
}

//tuple pattern
val tuple1=(1,2,3)
val tuple2=(1,2,3,4)
def tupleDemo(expr:Any)=
 expr match {
   case (a,b,c) => println("Matched"+expr)
   case _ =>
 }

tupleDemo(tuple1)
tupleDemo(tuple2)

tuple1 match {
  case (a,b,c) => println("tuple1 matches 3 element")
  case _ => println("not match")
}

//compile error
//tuple2 match {
 // case (a,b,c) => println("tuple1 matches 3 element")
  //case _ => println("tuple2 not match")
//}

def generalSize(x:Any)=x match{
  case s:String => s.length
  case m:Map[_,_] => m.size
  case _ => -1
}

println(generalSize("abc"))
println(generalSize(Map(1->'a',2->'b')))
println(Math.Pi)



