package testPackage

/**
 * Created by luruirui on 14-11-25.
 */

//Private
class Outer {

  class Inner {
    private def f() {
      println("f")
    }

    class InnerMost {
      f()
    }

  }

  //  new Inner().f()  //compile error
}

//Protected:only subclass accessible
package p1 {

class Super {
  protected def f() {
    println("f")
  }
}

class Sub extends Super {
  f()
}

class Other {
  //    new Super().f()  //compile error
}

}

package bobsrockets {
package navigation {

private[bobsrockets] class Navigator {
  private[this] var speed = 200
  protected[navigation] def useStarChart() {}
  class LegOfJourney {
    private[Navigator] val distance = 100
  }
}
}

package launch {

import testPackage.bobsrockets.navigation._

object Vehicle {
  private[launch] val guide = new Navigator
}

}

}

object AccessModifiers {

}
