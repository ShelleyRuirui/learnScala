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

  def newWritePrintWriter(file:File)(op:PrintWriter=>Unit): Unit ={
    val writer=new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  //Demo by-name param: start with =>
  def myAssert(predicate: =>Boolean)=
    if(!predicate)
      throw new AssertionError

  def main (args: Array[String]) {
    println("Twice:"+ControlFlow.twice(_+1,5))

    withPrintWriter(new File("date.txt"),out=>out.println(new Date()))

    val file=new File("date2.txt")
    //call function of single param
    newWritePrintWriter(file){
      writer=>writer.println(new Date())
    }

    myAssert(5<3)
  }
}
