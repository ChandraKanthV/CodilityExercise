def solution(a: Array[Int]): Int = {
  if(a.length< 1 ) return  0

  val aSorted = a.sorted
  for (i <- 0 until  a.length)
    if (aSorted(i) != i+1)
      return 0
  return 1
}

val A: Array[Int] = Array(3,2,1)
val premcheck = solution(Array.emptyIntArray)

/*

var largeArray:Array[Int] = Array.emptyIntArray
for (i <- (0 until  100000))
  largeArray = largeArray :+ i+1
*/