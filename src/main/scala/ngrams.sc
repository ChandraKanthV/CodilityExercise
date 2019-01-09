val basis = List(1, 2, 3, 4)
val nGrams1 = (basis sliding 1).toList ::: (basis sliding(2)).toList
//println("length od nGrams1: ", nGrams1.t )
nGrams1.foreach(println _)

var cnt =0
val nGrams2 = for(i <- 0 until basis.length) yield (basis.sliding(i+1)).toList
val nGrams3 = nGrams2.flatten
nGrams3.foreach(println _)