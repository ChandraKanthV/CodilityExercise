def solution(a: Int, b: Int): String = {

  return  ""
}


val a=  3
val b =8

var greater= math.max(a,b)
var lesser = math.min(a,b)

if(( greater / lesser) >= 2)
println("Impossible")
var ret:String =""
var i =0
var j =0

if(a<b) {
  println("entred if")
  while ((i <= j) && (i <= a) && (j <= b)) {
    println("entred while")
    ret += "bb"
    ret += "a"

    i += 1
    j += 2

  }

  i = i - 1
  j = j - 2
  println(i,j)

  while ((i <= a) && (j <= b)) {
    ret += "a"
    ret += "b"
    i += 1
    j += 1
  }
  println(i-1,j-1)

}


println(i,j)
println(ret)