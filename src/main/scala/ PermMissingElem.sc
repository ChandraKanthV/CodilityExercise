import scala.util.Try

def solution(a: Array[Int]): Int = {

  def testInputParams(): String = {
    if(a.isEmpty) throw new IllegalArgumentException ("Input Array is empty \n")
    if((a.length < 0) || (a.length>100000)) throw new IllegalArgumentException ("Input Array limits out of range \n")
    if (a.length != a.distinct.length) throw new IllegalArgumentException ("one or more elements in the input array are repeated \n")
    if(a.sorted.last > a.length+1) throw new IllegalArgumentException ("Some elements of the input array are greater thaan N+1 \n")
    if(a.sorted.head < 1) throw new IllegalArgumentException ("Some elements of the input array are less tha 1 \n")

    return null
  }

  try{
    testInputParams()
  }catch {
    case e:IllegalArgumentException=> {
      throw  new IllegalArgumentException (" INVALID INPUT ARGUMENTS: " + e)
    }
  }

  ((a.length+1)*(a.length+2)/2) - a.fold(0)(_ + _)


}

val A:Array[Int] = Array(2,2,4)
val B:Array[Int] = Array.emptyIntArray

val z = solution(A)
//val z1 = A.sorted