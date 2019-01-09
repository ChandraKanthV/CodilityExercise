def solution(n: Int): Int = {
  if (n == 0) return 0
  if(n == 1) return 1

  var ret=2
  val sqrt:Int = math.sqrt(n).toInt
  for(i <- (2 to   sqrt)){
    println("--->", i)
    if(n%i == 0) ret +=2
  }

  if(sqrt*sqrt == n) ret -=1
  return  ret
}

println(solution(24))