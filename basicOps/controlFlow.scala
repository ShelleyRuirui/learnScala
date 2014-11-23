import java.io.{IOException, FileNotFoundException, FileReader, File}
import java.lang.String
import java.net.MalformedURLException
import java.net.URL

/**
 * Created by luruirui on 14-11-23.
 * Some example code from Programming in Scala
 */

//For body
val filesHere=(new File(".")).listFiles()

def fileLines(file:File) ={
  scala.io.Source.fromFile(file).getLines().toList
}

def grep(pattern:String)=
for (file <- filesHere
     if file.getName.endsWith(".scala"); //if for {} this semicolon
     line <- fileLines(file)
     if (line.trim.matches(pattern))
) println(file+":"+line.trim)

grep(".*gcd.*")

def scalaFiles=
for{
  file<-filesHere
  if file.getName.endsWith(".scala")
} yield file

println(scalaFiles)


//Exception body
def myhalf(n:Int)=
  if(n%2==0)
    n/2
  else
    throw new RuntimeException("n must be even")

println("Myhalf(2)"+myhalf(2))
//println("Myhalf(1)"+myhalf(1))

def tryReadFile(): Unit ={
  try{
    val file=new FileReader("input.txt");
  }catch{
    case ex:FileNotFoundException=>System.err.println("Exception:file not found")
    case ex:IOException=>System.err.println("Exception:io")
  }
}

tryReadFile();

//can return value
def urlFor(path:String)=
try{
  new URL(path)
}catch{
  case e:MalformedURLException=>
    new URL("http://www.scala-lang.org")
}

println(urlFor("hi"))
println(urlFor("http://www.google.com"))

//Match structure
val args=new Array[String](2);
args(0)="Korean"
//args(0)="British"
//Chinese and Korean print partly in intellij
val firstArg= if(args.length>0) args(0) else ""
firstArg match{
  case "Chinese" => println("你好   ")
  case "America" => println("Hello")
  case "Korean" => println("안녕하세요     ")
  case _ => println("Huh?")
}