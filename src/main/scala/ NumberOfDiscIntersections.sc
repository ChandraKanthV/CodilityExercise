
def solution(a: Array[Int]): Int= {

  var (activeCircles, intersections) = (0,0)

  val cP= for (index <- (0 until a.length) )
    yield List((index -a(index),true),(index +a(index ), false))

  val circlePoints = cP.flatten
  val circlePointsSorted = circlePoints.sortWith(
    (v1:(Int,Boolean), v2:(Int,Boolean)) =>
    {if(v1._1 < v2._1) true else if (v1._1 == v2._1) v1._2 else false }
  )

  for(i <- circlePointsSorted){
    if(i._2) {intersections += activeCircles; activeCircles +=1;}
    else activeCircles -=1
    if (intersections > 10000000) return -1
  }

  return  intersections
}


println(solution(Array(1,5,2,1,4,0)))



/*
val circleProp= for (i<-(0 until a.length ))
  yield ( i-a(i),  i+a(i))
println(circleProp)
var counter:Int = 0

for {
  i <- (0 until a.length - 1)
  j <- (i + 1 until a.length)
} {

  if(!
    (
      (circleProp(i)._2 < circleProp(j)._1) ||
        (circleProp(i)._1 > circleProp(j)._2 )
      )
  ) counter =counter+1
  }
  println(counter)

*/


  val (i , j) = (0,1)
  println(j)
  println(i)
