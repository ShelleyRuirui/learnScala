class ChecksumAccumulator{
  private var sum=0
  def add(b:Byte):Unit={ //b is val not var 
    sum+=b  
  }
  /*
  def add(b:Byte):Unit=sum+=b
  def add(b:Byte){sum+=b} //type Unit without =
  */

  
  def checksum():Int={
    return ~(sum&0xFF)+1
  }
}


import scala.collection.mutable.Map

object ChecksumAccumulator{
  private val cache=Map[String,Int]()

  def calculate(s:String):Int=
    if(cache.contains(s))
      cache(s)
    else{
      val acc=new ChecksumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs=acc.checksum()
      cache+=(s->cs)
      cs
    }
}

// println(ChecksumAccumulator.calculate("Every value is an object"))
