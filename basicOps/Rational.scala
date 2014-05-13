class Rational(n:Int,d:Int){
  //println("Created "+n+"/"+d)
  require(d!=0)
  
  private val g=gcd(n.abs,d.abs)
  val numer:Int=n/g
  val denom:Int=d/g
  override def toString=numer+"/"+denom

  def +(that:Rational):Rational=
    new Rational(numer*that.denom+that.numer*denom,denom*that.denom)

  def *(that:Rational):Rational=
    new Rational(numer*that.numer,denom*that.denom)

  def +(i:Int):Rational=
    new Rational(numer+i*denom,denom)


  def lessThan(that:Rational)=
    this.numer*that.denom<that.numer*this.denom

  def this(n:Int)=this(n,1)

  private def gcd(a:Int,b:Int):Int=
    if(b==0) a else gcd(b,a%b)
}

val oneHalf=new Rational(1,2)
val twoThirds=new Rational(2,3)

//println(new Rational(1,2))
val sum=oneHalf + twoThirds
println(sum)
val x=oneHalf
val y=twoThirds
val sumMul=x+x*y
println(sumMul)
val r1=new Rational(2)
println(r1)

val r2=new Rational(66,42)
println(r2)

val r3=x+2
println(r3)

implicit def intToRational(x:Int)=new Rational(x)
val r4=2+x
println(r4)
