def solution(a: Array[Int]): Int ={

  val aSorted = a.sorted
  for (i <- (0 until  a.length-2))
    if( (aSorted(i) + aSorted(i+1)) > aSorted(i+2)) return 1
  return 0
}

val z = solution(Array(10,2,5,1,8,20))
