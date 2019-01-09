import scala.util.control.Breaks._

def solution(a: Array[Int], b: Array[Int]): Int = {

  try{
    val n:Int = a.length
    if(a.length != b.length) throw new IllegalArgumentException("The two arrays are not of equal length")
    if( (n<1) ||(n>100000)) throw new IllegalArgumentException("n is out of bounds")
    if(a.min < 1) throw new IllegalArgumentException ("some elements in 'a' are less than 1")
    if(b.min < 1)  throw new IllegalArgumentException ("some elements in 'b' are less than 1")
    if(a.max > 100000000) throw new IllegalArgumentException("some elements in 'a' are greater than 100,000,000")
    if(b.max > 100000000) throw new IllegalArgumentException("some elements in 'b' are greater than 100,000,000")
  }catch {
    case e:IllegalArgumentException => throw new IllegalArgumentException (e)

  }

  val n = a.length
  var rangeVals = (1 to n).toSet
  var missingVals = rangeVals -- a
  //println(missingVals)

  if(missingVals.isEmpty)
    return a.max+1

  var firstMissingVal:Int = missingVals.min

  if(!  b.contains(firstMissingVal))
    return firstMissingVal

  var abZippedSorted = a.zip(b).sorted
  var ab1 = abZippedSorted.unzip
  /* convenience variable for easy reference*/
  var a1 = ab1._1
  var b1 = ab1._2
//  a1.foreach(println _)
//  b1.foreach(println _)
  //println(abZippedSorted.toList)



  def swap(index: Int) = {
    val temp = b1(index)
    b1(index) = a1(index)
    a1(index) = temp

    //missingVals = missingVals.tail
  }

  while ((firstMissingVal > 0) && (b1.contains(firstMissingVal))) {
    //println(firstMissingval)
    //firstMissingVal +=1
    val b1Indexed = b1.zipWithIndex
    val firstMissingValB1Indexes:List[Int] = b1Indexed.filter(_._1 == firstMissingVal).map(_._2).toList
    println(firstMissingValB1Indexes)
    //println(firstMissingVal, " =>firstMissingValIndexes ", firstMissingValB1Indexes)

    //println("\t\t\t\t\t\t\t\t\t begining a1", a1.toList)
    //println("\t\t\t\t\t\t\t\t\t begining b1", b1.toList)
    //println("\t\t\t\t\t\t\t\t\t begining missingVals",missingVals.toList)


    /*
    * There are four possible cases, in the following order of priority
    * 1) there are repeating pairs of matching (a1,b1).ex: (10,6)(10,6)
    *     extra pair of (a1,b1) is useless so it is safest to remove one
    * 2) no repeating pairs but duplicates of matching a1. ex:(10,6)(10,11)(11,6)
    *     because the a1 is sorted, the dulicate must be to  the right or left of current index
    * 3) more than 1 possible a1's but are distinct and unique.Ex: (10,6)(11,6)(18,6)
    * 4) only one possible a1, swap (a1,b1) only if that a1 is greater than b1
    * */

    var index = 0

    //case 4:
    if (firstMissingValB1Indexes.length < 1)
      throw new Exception("This scenerio should have never occured")
    if (firstMissingValB1Indexes.length == 1) {
      println("INSIDE CASE 4")
      //check if the swap is legal
      if (b1(firstMissingValB1Indexes(0)) < a1(firstMissingValB1Indexes(0))) {
        index = firstMissingValB1Indexes(0)
        println("INSIDE CASE 4 IF")
        //swap(firstMissingValB1Indexes(0))
      }

      else {
        println("INSIDE CASE 4 ELSE")
        //println("*************  the largest score of the game is: ", firstMissingVal)
        return  firstMissingVal
      }
      // continue
    }
    else {
      //println("INDES MAIN ELSE")
      val matchingA1Vals = for (i <- firstMissingValB1Indexes) yield a1(i)
      val dupsInA1Vals = matchingA1Vals.diff(matchingA1Vals.distinct).distinct
      //println(" =>matchinA1Vals ", matchingA1Vals)
      //println(" =>dupsInA1Vals ", dupsInA1Vals)

      /*
      * if dupsInA1Vals is NOT empty means case 1
      * else cse 2 or 3    *
      * */
      // case 1:
      if (!dupsInA1Vals.isEmpty) {
        //println("INSIDE CASE 1")
        //there is atleast one (a1,b1) pair
        val muldupInd = matchingA1Vals.indexOf(dupsInA1Vals.head)
        index = firstMissingValB1Indexes(muldupInd)
        //swap(index)
      }
      else {
        //println("INSIDE THE NOT ONE CASE ELSE")
        /*
        * This else case o=is for case 2 or 3
        *
        * */
        //case 2
        if (firstMissingValB1Indexes.exists(p => ((a1(p) == a1(p + 1)) || (a1(p) == a1(p + 1))))) {
          //println("iNSIDE THE CASE 2")
          breakable {
            for (i <- firstMissingValB1Indexes) {
              if ((a1(i) == a1(i - 1)) || (a1(i) == a(i + 1)))
                index = i
              //swap(i)
              break
            }
          }
        }
        else {
          //case 3
          //println("INSIDE THE CASE 3")
          index = firstMissingValB1Indexes.last
          //swap(index)
        }
      }
    }
    //println("THE INDEXX IS: ", index)
    swap(index)
    println(a1.toList)
    println(b1.toList)
    //missingVals = missingVals -- Set(firstMissingVal)
    missingVals = rangeVals -- a1

    if (missingVals.isEmpty) {
      //println("*************  the largest score of the game is: ",firstMissingVal)
      return a1.max+1
    }
    else {
      firstMissingVal = missingVals.min
      println("reassinging first missing value:", firstMissingVal)
    }


    //println("\t\t\t\t\t\t\t\t\t ending a1", a1.toList)
    //println("\t\t\t\t\t\t\t\t\t ending b1", b1.toList)
    //println("\t\t\t\t\t\t\t\t\t ending missingVals",missingVals.toList)

  }

  //println("Execution should have never come this far")
  return -1
}

println("started execution")
val a: Array[Int] = Array(1, 2, 3, 3, 10, 10, 10, 13, 18, 5, 13)
val b: Array[Int] = Array(9, 10, 11, 4, 6, 6, 7, 4, 8, 4, 4)

val c1 = Array(1,2,3,4,5,8)
val c2 = Array(7,8,9,1,5,7)

//val firstMissingVal = solution(a,b)
//println("===>Last firstMissingVal is: ", solution(a,b))
println("===>Last firstMissingVal is: ", solution( Array(4, 2, 1, 6, 5), Array(3, 2, 1, 7, 7)))
