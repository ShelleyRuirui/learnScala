package testPackage{

  package level1{
    class Level1Class1
  }

  package level2{
    class Launch{
      //No need to write testPackage.level1.level1Class1 A little like file system
      //Others may need to ref from top most packages
      val v=new level1.Level1Class1
    }
  }

  object TestPackage {

  }
}

/**
 * Created by luruirui on 14-11-25.
 */



