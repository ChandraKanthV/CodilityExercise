import scala.math
import scala.util.Try

def solution(x: Int, y: Int, d: Int): Int = {

  def testInputs(): Option[Unit] = Try {
    if(x > y) throw new IllegalArgumentException(" X > Y")
    if(! ( (1 to 1000000000) contains  x) ) throw new IllegalArgumentException(" X is not Valid ")
    if(! ( (1 to 1000000000) contains  y) ) throw new IllegalArgumentException(" y is not Valid ")
    if(! ( (1 to 1000000000) contains  d) ) throw new IllegalArgumentException(" d is not Valid ")
    //if ((y ==0) ||(d==0)) throw new IllegalArgumentException(" y and/or d cannot be zero ")
  }.toOption

  testInputs match {
    case Some(s  ) => ;
    case None => {
      println("invalid arguments: ")
      throw new IllegalArgumentException(" d is not Valid ")
    }
  }

  val divdend = ((y-x)/d)
  if(divdend*d == (y-x)) return divdend else return divdend+1
}

solution(1,1,1)