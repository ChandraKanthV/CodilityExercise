
val S ="1A 2F 1C"
val N = 4

var ss = S.split(" ").sorted
var sslen = ss(0).length
var ssNum:Array[Int] =Array()
//ssNum = ssNum :+ 4

var totalCount:Array[Int] = Array.fill(N+1)(0)


val a1:Array[Array[Int]] = Array.ofDim[Int](N+1, 3)
val a2:Array[Array[Int]] = Array.ofDim[Int](N+1, 4)
val a3:Array[Array[Int]] = Array.ofDim[Int](N+1, 3)

for(i <- (0 to N )){
  a1(i)(0) = 0
  a1(i)(1) = 0
  a1(i)(2) = 0
}
for(i <- (0 to N )) {
  a2(i)(0) = 0
  a2(i)(1) = 0
  a2(i)(2) = 0
  a2(i)(3) = 0
}
for(i <- (0 to N )){
  a3(i)(0) = 0
  a3(i)(1) = 0
  a3(i)(2) = 0
}

for(i<-ss) {
  println(i.slice(0, i.length - 1).toInt)
  ssNum = ssNum :+ i.slice(0, i.length - 1).toInt
}
val notinSSnum = (1 to N).toSet.filterNot(p => ssNum.contains(p))
var finalCount:Array[Array[Int]] = Array.ofDim[Int](N+1, 3)
for(i <- (0 to N)){
  finalCount(i)(0) = 1
  finalCount(i)(1) = 1
  finalCount(i)(2) = 1
}
//println("final", finalCount(3).toList)

for (i<-ss)
  {
    val row = i.slice(0, i.length - 1).toInt
    val seat = i.last

    if( ((seat == 'A') || (seat =='B') || (seat == 'C')) && finalCount(row)(0)==1 )
      finalCount(row)(0) = 0

    if( ((seat == 'D') || (seat =='E') || (seat == 'F') || (seat == 'G')) && finalCount(row)(1)==1 )
      finalCount(row)(1) = 0

    if( ((seat == 'H') || (seat =='J') || (seat == 'K')) && finalCount(row)(2)==1 )
      finalCount(row)(2) = 0
  }

var ret = 0

var z = finalCount(3).groupBy(identity).toList
for (i <-  (1 to N)){
  println("Row: ",i, " :: ", finalCount(i)(0), finalCount(i)(1), finalCount(i)(2))
  ret += finalCount(i)(0) + finalCount(i)(1) + finalCount(i)(2)
}
println(ret)

/*
for(i<-(0 until N)){
  var aisle1 = Array.fill(3)(1)
  var aisle2 = Array.fill(4)(1)
  var aisle3 = Array.fill(3)(1)

}
println(ssNum.toList)
var aisle1 = Array.fill(3)(1)
var aisle2 = Array.fill(4)(1)
var aisle3 = Array.fill(3)(1)


var s2 = ss(1)(sslen-2)
for (i <- ss){
  println(i(sslen-2))
  i(sslen-2) match {
    case 'A' => aisle1(0) =0
    case 'B' => aisle1(1) =0
    case 'C' => aisle1(2) =0
    case 'D' => aisle2(0) =0
    case 'E' => aisle2(1) =0
    case 'F' => aisle2(2) =0
    case 'G' => aisle2(3) =0
    case 'H' => aisle3(0) =0
    case 'J' => aisle3(1) =0
    case 'K' => aisle3(2) =0

  }
}
println(aisle1.toList)
println(aisle2.toList)
println(aisle3.toList)

*/




/*def solution(a: Int, b: Int, k: Int): Int = {
  try{
    if(b < a) throw new IllegalArgumentException("b < a")
    if(! (0 to  2000000000).contains(a)) throw new IllegalArgumentException("a out of rang")
    if(! (0 to  2000000000).contains(b)) throw new IllegalArgumentException("b out of rang")
    if(! (1 to 2000000000).contains(k) ) throw  new IllegalArgumentException("k is Invalid" )
  }
  catch {
    case e:IllegalArgumentException => {
      sys.exit()
    }
  }


  return 0

}

println(solution(10,20,3))
*/

