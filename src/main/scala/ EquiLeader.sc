def solution(a: Array[Int]): Int = {
  val n = a.length
  var count  = 0
  for(i <- (1 until n))
  {
    //println( A.slice (0 , i).toList, A.slice(i , n).toList)

    val a1 = a.slice(0,i)
    val a2 =a.slice(i,n)
    val a1_max = a1.groupBy(identity).maxBy(_._2.size)
    val a2_max = a2.groupBy(identity).maxBy(_._2.size)
    //println(" a1 and a2 lists are: ", a1_max._2.toList,a2_max._2.toList)

    if((a1_max._1 == a2_max._1) &&(a1_max._2.length > (a1.length/2)) &&
      (a2_max._2.length > (a2.length/2)))
    {
      count += 1
      //println("     valid for :", a1.toList, a2.toList)
    }
  }
  return count

}

println("count is: ", solution(Array(1,2,1,2,1,2,1,2,3,1)))

/*
val A1 = Array (4, 3)
val A2  = Array(4, 4, 4, 2)

val a2 = A2.map(x => (x,1))
val a3 = List(1, 3, 4, 4, 2).groupBy(identity).maxBy(_._2.size)._1
*/

