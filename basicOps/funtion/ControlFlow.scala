package funtion

import java.io.{PrintWriter, File}
import java.util.Date

/**
 * Created by luruirui on 14-11-24.
 */
object ControlFlow {

  def twice(op:Double=>Double,x:Double)=op(op(x))

  def withPrintWriter(file:File,op:PrintWriter=>Unit): Unit ={
    val writer=new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }

  }

  def main (args: Array[String]) {
    println("Twice:"+ControlFlow.twice(_+1,5))

    withPrintWriter(new File("date.txt"),out=>out.println(new Date()))
  }
}
