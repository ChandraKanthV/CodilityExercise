
def solution(n:Int , m:Int):Int = {

  assert( ((n>0) && (n <=1000000000)) , "n is out of bounds")
  assert( ((m>0) && (m <=1000000000)) , "n is out of bounds")

  var x = 0
  var eaten:Set[Int] = Set()

  if(!(eaten contains x) ) eaten = eaten + x

  return  0
}

val result = solution(10,4)


var x = 10
var eaten:Set[Int] = Set()
var l:List[Int] = (0 until 10).toList

var arr:Array[Int] = Array(1,2,3,4,5,6,7,8,9)

var max_slice = arr(0)
var max_sliceEndingHere = arr(0)

for (i <- arr){
  max_sliceEndingHere = math.max(i, max_sliceEndingHere+i)
  max_slice = math.max(max_slice,max_sliceEndingHere)

}

println(max_slice)

