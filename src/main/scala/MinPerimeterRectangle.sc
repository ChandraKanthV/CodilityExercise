
def solution(n: Int): Int = {
  for( i <- (math.sqrt(n).toInt until  0 by -1 ))
    if( n%i ==0)
      return 2*(i + (n/i))
  throw new Exception("Should have never reached here")
}

println(solution(24))