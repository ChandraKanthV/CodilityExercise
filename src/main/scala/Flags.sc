def solution(a: Array[Int]): Int = {

  a.length match  {
    case 0 => return 0
    case 1 => return 1
    case 2 => if(a(0) == a(1)) return 0 else 1
    case _ =>
  }

  var n: Int = 0
  var k: Int = 0
  var peaks: Array[Int] = Array()

  if (a(0) > a(1)) peaks = peaks :+ 0

  for (i <- (1 until (a.length - 1) ))
    if ((a(i) > a(i - 1)) && (a(i) > a(i + 1)))
      peaks = peaks :+ i

  if (a(a.length - 1) > a(a.length - 2))
    peaks = peaks :+ a.length-1
  peaks.foreach(println _ )

  k = peaks.length
  if(k == 0) return  0

  n = peaks(k - 1) - peaks(0)
  println(k, n)

  for (i <- (k until  0 by -1)){
    println(i, n / i, ((n / i) >= i))
    if ((n / i) >= i) return i
  }
  return 1
}

val a:Array[Int] = Array(5,1,5,1,5,1,1,1,1,1,1,5)
println(solution(a))