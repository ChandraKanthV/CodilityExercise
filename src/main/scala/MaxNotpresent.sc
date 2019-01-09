def solution(a: Array[Int], b: Array[Int]): Int  = {

  var currentMin:Int = 0

  val aSorted = a.sortWith(_ < _)
  var abZiped = a.zip(b)
  for ( i <- abZiped)
    print (i)
  //print(abZiped.toList, aSorted.toList, aSorted(0), aSorted(aSorted.length-1))
  

  return 4
}

val A: Array[Int] = Array(4, 2, 1, 6, 5)
val B:Array[Int] = Array(3, 2, 1, 7, 7)
print(A.toList)
print(B.toList)

solution(A,B)