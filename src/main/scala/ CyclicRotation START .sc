


def solution(a: Array[Int], k: Int): Array[Int] ={

  var retArray = Array.emptyIntArray

  for(i <- (a.length-k to a.length-1))
    retArray = retArray :+ a(i)
  for(i <- 0 until  a.length-k)
    retArray = retArray :+ a(i)

  return  retArray
}

val A:Array[Int] = Array(3, 8, 9, 7, 6)
val kRotated = solution(Array(1,2,3,4),4)