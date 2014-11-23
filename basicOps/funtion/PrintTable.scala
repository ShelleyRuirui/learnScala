
package funtion

/**
 * Created by luruirui on 14-11-23.
 */
object PrintTable {

  def makeRowSeq(row:Int)=
    for(col<-1 to 10) yield{
      val prod=(row*col).toString
      val padding=" "*(4-prod.length)
      padding+prod
    }

  def makeRow(row:Int)=makeRowSeq(row).mkString

  def multiTable(n:Int)={
    val table=
       for(row<-1 to n)
         yield makeRow(row)

    table.mkString("\n")
  }


  def main(args: Array[String]) {
    println(multiTable(10))
  }
}
