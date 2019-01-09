/*
val a = Array(3,1,2,3,6)
//val a = Array(2,3)
val r = a.filter(p => ((3%p) != 0))

val z = for {
  i <- a
} yield a.filter(p => ((i%p) != 0)).length
*/

//val a = Array(3,1,2,3,6)
def solution(a: Array[Int]): Array[Int] = {
  val n =a.length
  val answerArray = Array.fill(2*n +1)(n)
  val occurrencesArray = Array.fill(n*2 +1)(0)
  occurrencesArray(0) = 0
  answerArray(0) = 0

  for(i <- a) occurrencesArray(i) += 1


  for(i <- (1 to 2*n)){
    var j =1
    while( j*i < 2*n+1){
      answerArray(j*i) -= occurrencesArray(i)
      j +=1
    }
  }
  val z = for (i <- a) yield  answerArray(i)
  return z
}
println(solution(Array(3,1,2,3,6)))

