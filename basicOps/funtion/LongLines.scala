package funtion

import java.io.File

import scala.io.Source

/**
 * Created by luruirui on 14-11-23.
 */
object LongLines {

  def processFile(file:File,width:Int): Unit ={
    def processLine(line:String): Unit ={
      if(line.length>width)
        println(file+":"+line)
    }

    val source=Source.fromFile(file)
    for(line<-source.getLines())
      processLine(line)
  }

  def main(args: Array[String]) {
    val files=(new File("./basicOps")).listFiles()
    for(file<-files if file.isFile)
      processFile(file,60)
  }
}
