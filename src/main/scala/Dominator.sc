def solution(a: Array[Int]): Int = {


  if(a.isEmpty) return -1

  val possibleDominator = a.groupBy(x => x).map{
    case (num,arr) => (num, arr.size)
  }.toList.sortBy(- _._2).head

  if(possibleDominator._2 <= a.size/2) return -1
  else return a.indexOf(possibleDominator._1)


}


val a:Array[Int] = Array(3,4,3,2,3,-1,3,3)
val zi = a.zipWithIndex
println(solution(Array()))



/*

val z = zi.groupBy( p => (p._1, p._2, p._1) )


/*
val k = if(z._2 <= a.size/2) z._1 else -1

val p = a.find(p => (p == z._1))
*/

val l = List(1,2,3,4,5,6,7,8,9,10).view.find(_ > 5).get
*/