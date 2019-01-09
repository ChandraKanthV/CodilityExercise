def solution(n: Int, a: Array[Int]): Array[Int] = {
  var maxCntVal = 0
  var retArray = Array.fill(n)(0)
  for(k <- a) {
    if(k == n+1) {
      retArray = Array.fill(n)(maxCntVal)
    }
    else {
      retArray(k - 1) += 1
      if (retArray(k - 1) > maxCntVal) maxCntVal = retArray(k - 1)
    }

  }


  return retArray
}

val A:Array[Int]= Array(3,4,4,6,1,4,4)
A.apply(4)
for(i <- A)
print(i)
val ret = solution(5,Array(6))

val f = A.reduceLeft(_ max _)