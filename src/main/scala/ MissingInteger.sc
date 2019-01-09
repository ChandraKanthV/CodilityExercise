def solution(a: Array[Int]): Int ={
  if(a.length == 1){
    if (a(0) ==1) return 2
    else return 1
  }
/*
  var rangeArray = (1 to a.length).toSet
  for (i <- a) rangeArray -= i

  if (rangeArray.isEmpty) 1 else rangeArray.min
*/



  var rangArray = (1 to a.length).toSet
  val missingNumbers = rangArray -- a.toSet

  if(missingNumbers.isEmpty) a.length+1
  else missingNumbers.min

}

val A:Array[Int] = Array(-1,3,8,3,9,5,1, 7, 6, 4, 0, 2,3)

/*
val rangArray = Array.range(1,A.length).toSet
val z = A.toSet -- rangArray

val y = rangArray.filterNot(p => (A contains(p)))
*/

val ret = solution(A)
var rangeArray = (1 to A.length).toSet
val mv = rangeArray -- A.toSet
var b= mv -- Set(10)
b = b ++ Set(12)
var c = A.indexOf(3,0)

