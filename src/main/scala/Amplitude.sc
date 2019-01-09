def solution(t: Array[Int]): String = {
  try{
    if(t.length %4 != 0 ) throw  new IllegalArgumentException(" yeaar day not multiple of 4")
    if(t.length < 8) throw  new IllegalArgumentException("length < 8")
    if(t.min < -1000) throw  new IllegalArgumentException("some element  <  -1000")
    if(t.max >1000 ) throw  new IllegalArgumentException("Some element > 1000")
  }
  catch {
    case e:IllegalArgumentException => { println(e)
      sys.exit()
    }
  }

  val seasons = t.sliding(t.length/4, t.length/4).toList
  val amplitudes = seasons.map(x => (x.max - x.min))

  val maxAmpSeason =  amplitudes.indexOf(amplitudes.max) //amplitudes.zipWithIndex.max._2

  /*TODO: case where more than two seasons have same max amplitude is not handled as it s not mentioned in the question
  what should be the valid return string
  * */


  return maxAmpSeason match {
      case 0 =>"WINTER"
      case 1 =>"SPRING"
      case 2 =>"SUMMER"
      case 3 =>"AUTUM"
    }


  return ""
}

//val  t = Array(-3,-14, -5 , 7, 8,42,8,2)
val  t = Array(13,14, 5 , 16, 8,8,8,8)


val seasons = t.sliding(t.length/4, t.length/4).toList
val amplitudes = seasons.map(x => (x.max - x.min))

val maxAmpSeason =  amplitudes.indexOf(amplitudes.max) //amplitudes.zipWithIndex.max._2
var ret :String = ""

println(solution(t))