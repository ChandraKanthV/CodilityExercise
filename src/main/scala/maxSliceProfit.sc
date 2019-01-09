def solution(a: Array[Int]): Int = {

  if (a.length <2) return 0

  var maxPriceFromHere = a(a.length-1)
  var maxProfit = 0

  for (i <- (a.length-1 to   0 by -1)){
    maxProfit = math.max(maxProfit, maxPriceFromHere- a(i) )
    maxPriceFromHere = math.max(a(i), maxPriceFromHere)
  }
  return  maxProfit
}

println(solution(Array(23171, 21011, 21123, 21366, 21013, 21367)))


val a = (10 until  0 by -1).toList