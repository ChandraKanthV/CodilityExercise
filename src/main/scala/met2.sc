def solution(n: Int, s: String): Int = {
  if(s.isEmpty) return n*3
  if((n < 1) || (n>50) || (s.isEmpty)) return 0

  var ss = s.split(" ").sorted
  var sslen = ss(0).length
  var ssNum: Array[Int] = Array()

/*
  val a1: Array[Array[Int]] = Array.ofDim[Int](n + 1, 3)
  val a2: Array[Array[Int]] = Array.ofDim[Int](n + 1, 4)
  val a3: Array[Array[Int]] = Array.ofDim[Int](n + 1, 3)

  for (i <- (0 to n)) {
    a1(i)(0) = 0
    a1(i)(1) = 0
    a1(i)(2) = 0
  }
  for (i <- (0 to n)) {
    a2(i)(0) = 0
    a2(i)(1) = 0
    a2(i)(2) = 0
    a2(i)(3) = 0
  }
  for (i <- (0 to n)) {
    a3(i)(0) = 0
    a3(i)(1) = 0
    a3(i)(2) = 0
  }

  1A 1F 1H 2A 2F 2H 3A 3F 3H 4A 4F 4H 5A 5F 5H 6A 6F 6H

*/
  for (i <- ss) {
    ssNum = ssNum :+ i.slice(0, i.length - 1).toInt
  }
  ssNum = ssNum.sorted

  val notinSSnum = (1 to n).toSet.filterNot(p => ssNum.contains(p))
  var finalCount: Array[Array[Int]] = Array.ofDim[Int](n + 1, 3)
  for (i <- (0 to n)) {
    finalCount(i)(0) = 1
    finalCount(i)(1) = 1
    finalCount(i)(2) = 1
  }

  var tempRow = 0
  var tempSeat = ' '

  for (i <- ss) {
    val row = i.slice(0, i.length - 1).toInt

    if (row <= n) {
      val seat = i.last

      if (((seat == 'A') || (seat == 'B') || (seat == 'C')) && finalCount(row)(0) == 1)
        finalCount(row)(0) = 0

      if (((seat == 'E') || (seat == 'F')) && finalCount(row)(1) == 1)
        finalCount(row)(1) = 0

      if (((seat == 'H') || (seat == 'J') || (seat == 'K')) && finalCount(row)(2) == 1)
        finalCount(row)(2) = 0

      if ((row == tempRow) && ((seat == 'D' && tempSeat == 'G') || (seat == 'G' && tempSeat == 'D')))
        finalCount(row)(1) = 0
      else {
        tempRow = row
        tempSeat = seat
      }
    }
  }


  var ret = 0
  for (i <- (1 to n)) {
    ret += finalCount(i)(0) + finalCount(i)(1) + finalCount(i)(2)
  }
  return ret

}


println(solution(2, ""))