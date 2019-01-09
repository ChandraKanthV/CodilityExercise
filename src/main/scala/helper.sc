val a1: Array[Int] = Array(1, 2, 3, 3, 5, 10, 10, 10, 13, 13, 18)
val mfvI = List(2, 4, 8, 9)

val res = mfvI.exists (p => ((a1(p) == a1(p+1)) || (a1(p) == a1(p+1)) ))

var rangeArray = (1 to a1.max).toSet
//val mv = (rangeArray -- a1).toList.sor
val findMax = (x: Int, y: Int) => {
  val winner = x max y
  val winner1 =math.max(x,y)
  println(s"compared $x to $y, $winner1 was larger")
  winner
}
a1.reduceLeft(findMax)
a1.reduceLeft( _ + _)
a1.reduceLeft(_ min _)
a1.reduceLeft(_ max _)

a1.fold(10)(_ + _)
a1.reduce(_ + _)

val b1 = Array("b","c","d")
b1.scan("a")( _ + _ )
b1.fold("")(_ + _)
b1.reduce(_ + _ )
b1.reduceLeft(_ + _)

var retArray = Array.emptyIntArray
retArray = retArray :+ 1

val g = a1.groupBy(identity)
//g.foreach(x => println(x._2.toList))
//val g1 = g.map(x => (x._1 -> x._2.length) ).sorted
val m = a1.groupBy(identity).mapValues(e => e.size)// e.map(x => x._2.size))
val m1 = m.toList.sortBy(- _._2)
