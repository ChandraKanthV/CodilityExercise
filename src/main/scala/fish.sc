import scala.util.control.Breaks._

def solution(a: Array[Int], b: Array[Int]): Int = {
  val c = a.zip(b)
  var stack:List[(Int, Int)] = List()
  var downstreamFishCount = 0
  var aliveCount = 0

  for(i <- c){
    if(i._2 ==1 ){
      stack = i +: stack
      downstreamFishCount +=1
    }
    else
    {
      breakable{

        while (downstreamFishCount > 0) {
          if (i._1 > stack.head._1) {
            downstreamFishCount -= 1
            stack = stack.tail
          }
          else break;
        }

      }
      if (downstreamFishCount == 0) aliveCount += 1
    }
  }
  return aliveCount+stack.length
}


val a:Array[Int] = Array(4,3,2,1,5)
val b:Array[Int] = Array(0,1,0,0,0)
println(solution(a,b))
