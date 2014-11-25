package testPackage

import testPackage.myPackage.Test

/**
 * Created by luruirui on 14-11-25.
 */

package streaming {
  package scheduler {

    private[streaming] trait ReceivedBlockStoreResult{
      def blockId:Int
    }

    private[streaming] class MyStoreRes extends ReceivedBlockStoreResult{
      override def blockId: Int = 10
    }

    private[streaming] case class ReceivedBlockInfo(id: Int,res:ReceivedBlockStoreResult){
      override def toString:String=
        "ReceivedBlockInfo:"+id
    }

    case class BatchInfo(str: String,map: Map[Int, Array[ReceivedBlockInfo]])

    object GetBatchInfo {
      def get(): BatchInfo = {
        var map = Map[Int, Array[ReceivedBlockInfo]]();
        val array = new Array[ReceivedBlockInfo](1);
        val myres=new MyStoreRes
        array(0) = new ReceivedBlockInfo(2,myres)
        map += (1 -> array)
        map += (2 -> array)
        new BatchInfo("hi", map)
     }
    }
  }
}

  package myPackage{

    import testPackage.streaming.scheduler.{GetBatchInfo, BatchInfo}

    class Test{
      def run(): Unit ={
        val batchInfo=GetBatchInfo.get()
//        val map:Map[Int, Array[ReceivedBlockInfo]]=batchInfo.map
        val map=batchInfo.map
        var res:Int=0



        map.foreach{
          case (k,v) => {
            for(info <- v){
              val clazz:Class[_]=Class.forName("testPackage.streaming.scheduler.ReceivedBlockInfo")
              val fields=clazz.getFields
              for(field <- fields){
                println("field:"+field.getName)
              }

              val methods=clazz.getMethods;
              for(method <- methods){
                println("method:"+method.getName)
              }

              val idMethod=clazz.getMethod("id")
              println("id method:"+idMethod.getName)
              println("val:"+idMethod.invoke(info).toString.toInt)
            }

//            res += clazz.getField("thisId").getInt(v)
//            res+=v.id
          }
        }

        println("res:"+res)
      }
    }
  }


object TestReflection {
  def main(args: Array[String]) {
    val t=new Test()
    t.run()
  }
}
