package testPackage

/**
 * Created by luruirui on 14-11-25.
 */
case class Purchase(name: String, orderNumber: Int, var shipped: Boolean)

object TryReflection {
  def main(args: Array[String]) {

    val p = Purchase("Jeff Lebowski", 23819, false)

    import scala.reflect.runtime.{universe => ru}
    val m = ru.runtimeMirror(p.getClass.getClassLoader)
    val shippingTermSymb = ru.typeOf[Purchase].declaration(ru.newTermName("shipped")).asTerm
    val im=m.reflect(p)
    val shippingFieldMirror = im.reflectField(shippingTermSymb)
    println(shippingFieldMirror.get)
  }
}
