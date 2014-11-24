package funtion

import java.io.File

/**
 * Created by luruirui on 14-11-24.
 */
object FileMatcher {

  private def filesHere=(new File(".")).listFiles

  private def filesMatching(matcher:String=>Boolean)=
    for{
      file<-filesHere
      if(matcher(file.getName))
    } yield file

  //Closure
  def filesEnding(query:String)=
    filesMatching(_.endsWith(query))

  def filesContaining(query:String)=
    filesMatching(_.contains(query))

  def main(args: Array[String]) {
    val res=FileMatcher.filesContaining("Scala")
    for(r<-res) println(r.getName)
  }
}
