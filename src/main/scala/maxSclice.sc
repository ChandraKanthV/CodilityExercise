def solution (a: Array[Int]): Int = {
  var max_slice = a(0)
  var max_sliceEndingHere = a(0)

  for (i <- a.takeRight(a.length-1)){
    max_sliceEndingHere = math.max(i, max_sliceEndingHere+i)
    max_slice = math.max(max_slice,max_sliceEndingHere)
  }
  return max_slice
}

println(solution(Array(3,2,-6,4,0)))