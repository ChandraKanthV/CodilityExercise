val a:Array[Int] = Array(1,2,3,4,5,6,7,8,9,10)

val  z = a.sliding(3,3)
z.foreach(a => println(a.toList))
val i:Int = 69
def isPrime1(n: Int): Boolean = ! ((2 to math.sqrt(n).toInt) exists (n % _ == 0))

println(i, "is ", if(isPrime1(i)) "is Prime" else "Not Prime" )