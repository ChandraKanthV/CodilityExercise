import java.io.IOException
import scala.util.{Try,Success,Failure}


def solution(a: Array[Int]): Int = {

  def testArrayLengthOdd(len: Int): Option[Unit] = Try {
      if( (len % 2) == 0) throw new IllegalArgumentException()
  }.toOption

  def testArrayLengthInRange(len: Int): Option[Boolean] = Try {
    if ( (1 to 1000000) contains  len) true else  throw new IllegalArgumentException
  }.toOption

  def testElementInRangeHelper(ele: Int): Option[Boolean] = Try {
    if ( (1 to 1000000000) contains  ele) true else  throw new IllegalArgumentException
  }.toOption
  def testElementInRange(ele:Int) = {
    testElementInRangeHelper(ele) match {
      case Some(_) => ;
      case None => print ("invalid arguments: element not in range ")
    }
  }


  testArrayLengthOdd(a.length) match {
    case Some(s  ) => ;
    case None => println("invalid arguments: even number of elements in the input array ")
  }
  testArrayLengthInRange(a.length) match {
    case Some(_) => ;
    case None => print("invalid arguments: Input length is not in range")
  }


  var oddElement = 0;
  val aDIstinct = a.distinct
  for ( i <- aDIstinct)
    {
      testElementInRange(i)


      if(a.count(_ == i) == 1) {
        try {
          if (oddElement != 0)
            throw new IllegalArgumentException("more than one odd elements")
        }catch {
          case e: IllegalArgumentException => {print("exception caught: " + e ); return -1;}
        }

        oddElement = i
      }

    }

  try {
    if (0 == oddElement)
      throw new IllegalArgumentException("No odd elements found")
  }catch {
    case e: IllegalArgumentException => {print("exception caught: " + e ); return -1;}
  }



  return oddElement
}

val aempty:Array[Int] = Array.emptyIntArray
val a:Array[Int] = Array(9,3,9,3,9,7,7,1,9)
val b:Array[Int] = Array(1000000000+1)
print((b.length))
val odd= solution(b)


//val list = List(1,2,4,2,4,7,3,2,4)
//val c = list.count(_ == 3)