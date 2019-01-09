def solution(a: Int, b: Int, k: Int): Int = {
  try{
    if(b < a) throw new IllegalArgumentException("b < a")
    if(! (0 to  2000000000).contains(a)) throw new IllegalArgumentException("a out of rang")
    if(! (0 to  2000000000).contains(b)) throw new IllegalArgumentException("b out of rang")
    if(! (1 to 2000000000).contains(k) ) throw  new IllegalArgumentException("k is Invalid" )
  }
  catch {
    case e:IllegalArgumentException => {
      println(e)
      sys.exit()
    }
  }

/*
  if(k==1) return (a to b).length
  var tempCount:Int =0
  for (i <- (a to b)){
    if ((i % k) ==0) tempCount = tempCount+1
  }
  return tempCount
*/
  /*
  val min_value =  ((a + k -1) / k) * k

  if (min_value > b)
    return 0

  return ((b - min_value) / k) + 1
*/
  if ((a % k) == 0)  return (b - a) / k + 1
  else  return (b - (a - a % k )) / k

}

val result : Int = solution(3, 9, 2)