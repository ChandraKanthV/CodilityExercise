
def solution(x: Int, a: Array[Int]): Int ={

  var distinctValsTillX = (1 to x).toSet
  for( i <- (0 until a.length)){
    distinctValsTillX -= a(i)
    if(distinctValsTillX.size == 0) return i
  }

  return -1
}

val A : Array[Int]= Array(1,3,1,4,2,3,5,4)
val ret = solution(3, A)

/*
var distinctValsTillX = (1 to 5).toSet
for (i <- distinctValsTillX)
  print(i)


if(distinctValsTillX.contains(3))
  distinctValsTillX -= 30

for (i <- distinctValsTillX)
  print(i)

print(distinctValsTillX.size)
*/