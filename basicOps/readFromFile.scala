import scala.io.Source

println("Not aligned")
if(args.length>0){
  for(line <- Source.fromFile(args(0)).getLines)
    println(line.length+" "+line)
}else
  Console.err.println("Please enter file name!")

println("-----------")
println("Aligned")

def widthOfLength(s:String)=s.length.toString.length

if(args.length>0){
  val lines=Source.fromFile(args(0)).getLines.toList

  val longestLine=lines.reduceLeft(
    (a,b) => if(a.length>b.length) a else b
  )

  val maxWidth=widthOfLength(longestLine)

  for(line <- lines){
    val numOfSpaces=maxWidth-widthOfLength(line)
    val padding=" "*numOfSpaces
    println(padding+line.length+" | "+line)
  }
}
else
  Console.err.println("Please enter filename!")
