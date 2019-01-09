

def solution(a: Array[Int]): Int = {
  var tempCount = 0;
  var indCount = 0;
  var sum = 0

  for (i <- a){
    if (i==0){
      sum = sum + indCount*tempCount
      //sum = 1794967296
      if(sum > 1000000000) -1
      tempCount=0
      indCount=indCount+1

    }
    else tempCount+=1
  }
  sum = sum+indCount*tempCount

  return if(sum > 1000000000) -1 else sum
}

val A:Array[Int] = Array(1,0,1,0,1,1)
val b = solution(A)

if(1794967296 > 1000000000)
  println("Yes greater")
else
  println("No lesser")
