def findPrims(n:Int): Array[Int] = {
  val tempArray = Array.fill(n+1)(1)
  tempArray(0) = 0
  tempArray(1) = 0
  var retPrims = Array()
  for(i <- (2 to math.sqrt(n).toInt)){
    if(tempArray(i) ==1){
      var k =i*i
      while (k <= n){
        tempArray(k) = 0
        k += i;
      }

    }
  }
  for(i <- (0 to n)){
    if(tempArray(i) != 0)
      retPrims += i
  }
println("ret prims:", retPrims)


  return Array(0,0)
}

def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int]= {

  val sqrtN = math.sqrt(n).toInt
  print(sqrtN)
  return Array(0,0)
}

findPrims(10)
//println(solution(10,Array(1,4,6), Array(26,10,20)))