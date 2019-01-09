import java.io.IOException

def solution(a: Array[Int]): Int = {
  // write your code in Scala 2.12
  case class customException(smth: String) extends Exception

  try {
    if ((a.length < 2) || (a.length > 100000))
      throw new IllegalArgumentException("invalid arguments: too few elements in the input")
  } catch {
    case e: IllegalArgumentException                => println("exception caught: " + e);
    case e: IllegalStateException    => println("illegal state exception");
    case e: IOException              => println("IO exception");
  }

  var partsums = Array.emptyIntArray
  val totalSum = a.fold(0) { (acc, i) => {
    try {
      if ((i < -1000) || (i > 1000)) throw new IllegalArgumentException("invalid arguments: value " + i + " out of valid range")
    } catch {
      case e: IllegalArgumentException => print("exception caught: " + e)
    }

      partsums = partsums :+ (acc + i)
      acc + i;


  }
  }

  partsums.fold(Int.MaxValue) { (acc, i) => math.min(acc, math.abs(totalSum - 2 * i)) }


}

val a: Array[Int] = Array(3,3)
val sol = solution(a)
sol