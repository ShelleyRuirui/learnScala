
import scala.reflect.runtime.{universe=>ru}
val l=List(1,2,3)

//Get type info
def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]
val theType = getTypeTag(l).tpe

println(theType)

val decls=theType.declarations.take(10)
println(decls)

//Use construnctor
case class Person(name:String)

//First obtain mirror
val m=ru.runtimeMirror(getClass.getClassLoader)
println(m)
//Second class mirror
val classPerson=ru.typeOf[Person].typeSymbol.asClass
println(classPerson)
val cm=m.reflectClass(classPerson)
println(cm)
//Final construct
val ctor=ru.typeOf[Person].declaration(ru.nme.CONSTRUCTOR).asMethod
val ctorm=cm.reflectConstructor(ctor)
val p=ctorm("Ruirui")
println(p)



