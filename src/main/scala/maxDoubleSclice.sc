//import scala.math._

def solution(a: Array[Int]): Int = {

  var maxDoubleSlicce = 0
  var startingArray:Array[Int] = Array.fill(a.size)(0)
  var endingArray:Array[Int] = Array.fill(a.size)(0)

  for(index <- (1 until a.length-1) ){
    endingArray(index) = math.max(0, endingArray(index-1) + a(index))
  }
  for (index <- (a.length-2 until  0 by -1) )
    startingArray(index) = math.max(0, startingArray(index+1) + a(index))



  for(index <- (1 until a.length-1))
    maxDoubleSlicce = math.max(maxDoubleSlicce, startingArray(index+1)+endingArray(index-1))

  return  maxDoubleSlicce
}

println(solution(Array(3,2,6,-1,4,5,-1,2)))
println(solution(Array(3,2,6,9 )))