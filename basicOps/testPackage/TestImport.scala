

/**
 * Created by luruirui on 14-11-25.
 */

package testPackage{
abstract class Fruit(
                      val name: String,
                      val color: String
                      )

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)
}
}

package pack2{
  import testPackage.Fruit
//  import testPackage._
//  import testPackage.Fruits._
  //Apple is renamed to McIntosh after import
  import testPackage.Fruits.{Apple => McIntosh, Orange}
  object Show{
    def showFruit(fruit:Fruit){
      import fruit._
      println(name+" "+color)
    }
  }

}



object TestImport {
  def main(args: Array[String]) {
    import pack2.Show
    import testPackage.Fruits._
    Show.showFruit(Orange)
  }

}
