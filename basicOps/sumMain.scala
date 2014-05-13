import ChecksumAccumulator.calculate

//The compiling is scalac ChechsumAccumulator.scala sumMain.scala & scala SumMain args
object SumMain{ 
  def main(args:Array[String]){
    for(arg<-args)
      println(arg+":"+calculate(arg))
  }
}

/*
Another way:
object xxx extends Application{
  //Here is main
  print...
}
*/
