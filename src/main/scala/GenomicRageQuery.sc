import java.io.IOException

def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
/*
  val impactFactor = Map('A' ->1, 'C'->2 , 'G'->3, 'T'->4)
  val intArr:Array[Int] = s.map(f => impactFactor.getOrElse(f,0)).toArray

  val retArray = for(i <- (0 until p.length))
    yield intArr.slice(p(i),q(i)+1).min

  return  retArray.toArray

*/


/*
  val impactFactor = Map('A' ->1, 'C'->2 , 'G'->3, 'T'->4)
  var min  = 0
  var temp:Int = 0
  var retArray:Array[Int] = Array.emptyIntArray
  for(i <-(0 until p.length)) {
    for(j <- (p(i) to q(i)) ) {
      temp = impactFactor.getOrElse(s(j),0)
      if(temp < min) min =temp
    }
    retArray =retArray :+ temp
  }
  return retArray
*/


  var retArray:Array[Int] = Array.fill(p.length)(-1)
  var A_visibility:Array[Int] = Array.fill(s.length)(-1)
  var C_visibility:Array[Int] = Array.fill(s.length)(-1)
  var G_visibility:Array[Int] = Array.fill(s.length)(-1)
  var T_visibility:Array[Int] = Array.fill(s.length)(-1)


  s(0) match {
    case 'A' => A_visibility(0) = 0
    case 'C' =>C_visibility(0) = 0
    case 'G' => G_visibility(0) = 0
    case 'T' => T_visibility(0) = 0
    case c   => throw new IllegalArgumentException("Encounterd illegal character '"+ c +"' in the input string at position 0 ")
  }

  for(i <- (1 until  s.length)) {
    A_visibility(i) = A_visibility(i-1)
    C_visibility(i) = C_visibility(i-1)
    G_visibility(i) = G_visibility(i-1)
    T_visibility(i) = T_visibility(i-1)

    s(i) match {
      case 'A' => A_visibility(i) = i
      case 'C' => C_visibility(i) = i
      case 'G' => G_visibility(i) = i
      case 'T' => T_visibility(i) = i
      case c => throw new IllegalArgumentException("Encounterd illegal character '" + c + "' in the input string at position " + i)

    }
  }

  val impactFactor = Map('A' ->1, 'C'->2 , 'G'->3, 'T'->4)
  for(i <- 0 until p.length)
  {
    if(q(i) < p(i)) throw new IllegalArgumentException("Invalid query: "+i)
    if(q(i) == p(i)) retArray(i) = impactFactor.getOrElse(s(q(i)), 0)
    else if(A_visibility(q(i)) > A_visibility(p(i)) ) retArray(i) =1
    else if(C_visibility(q(i)) > C_visibility(p(i)) ) retArray(i) =2
    else if(G_visibility(q(i)) > G_visibility(p(i)) ) retArray(i) =3
    else if(T_visibility(q(i)) > T_visibility(p(i)) ) retArray(i) =4
  }

  return retArray
}

val s:String =  "ACGT"
val s1:String = "GGGGGGGGG"
val p:Array[Int] = Array(0,0,1)
val q:Array[Int] = Array(0,1,1)

// val result = solution(s,p,q)


var retArray:Array[Int] = Array.fill(p.length)(-1)
var A_visibility:Array[Int] = Array.fill(s.length)(-1)
var C_visibility:Array[Int] = Array.fill(s.length)(-1)
var G_visibility:Array[Int] = Array.fill(s.length)(-1)
var T_visibility:Array[Int] = Array.fill(s.length)(-1)


s(0) match {
  case 'A' => A_visibility(0) = 0
  case 'C' =>C_visibility(0) = 0
  case 'G' => G_visibility(0) = 0
  case 'T' => T_visibility(0) = 0
  case c   => throw new IllegalArgumentException("Encounterd illegal character '"+ c +"' in the input string at position 0 ")
}

for(i <- (1 until  s.length)) {
  A_visibility(i) = A_visibility(i-1)
  C_visibility(i) = C_visibility(i-1)
  G_visibility(i) = G_visibility(i-1)
  T_visibility(i) = T_visibility(i-1)

  s(i) match {
    case 'A' => A_visibility(i) = i
    case 'C' => C_visibility(i) = i
    case 'G' => G_visibility(i) = i
    case 'T' => T_visibility(i) = i
    case c => throw new IllegalArgumentException("Encounterd illegal character '" + c + "' in the input string at position " + i)

  }
}

println(A_visibility.toList)
println(C_visibility.toList)
println(G_visibility.toList)
println(T_visibility.toList)

val impactFactor = Map('A' ->1, 'C'->2 , 'G'->3, 'T'->4)
for(i <- 0 until p.length)
{
  if(q(i) < p(i)) throw new IllegalArgumentException("Invalid query: "+i)
  else if(q(i) == p(i)) retArray(i) = impactFactor.getOrElse(s(q(i)), 0)
  else if(A_visibility(q(i)) > A_visibility(p(i)) ) retArray(i) =1
  else if(C_visibility(q(i)) > C_visibility(p(i)) ) retArray(i) =2
  else if(G_visibility(q(i)) > G_visibility(p(i)) ) retArray(i) =3
  else if(T_visibility(q(i)) > T_visibility(p(i)) ) retArray(i) =4
}

println(retArray.toList)



/*
for(i <- (0 until p.length))
  println( "[",i,"]", s.slice(p(i),q(i)+1))
*/




/*
val impactFactor = Map('A' ->1, 'C'->2 , 'G'->3, 'T'->4)
val a:Int = impactFactor.getOrElse('T', 0)


val   arr = Array("A", "T", "G")
val intArr:Array[Int] = s.map(f => impactFactor.getOrElse(f,0)).toArray

val min:Int = intArr.slice(0,2).min
*/