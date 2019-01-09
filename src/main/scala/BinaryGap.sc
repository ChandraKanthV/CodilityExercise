import java.io.IOException

def solution(n: Int): Int =  {

  try {
    if ((n < 1 ) || (n > Int.MaxValue))
      throw new IllegalArgumentException("invalid arguments: not in range")
  } catch {
    case e: IllegalArgumentException                => {println("exception caught: " + e); return -1;}
    case e: IllegalStateException    => println("illegal state exception");
    case e: IOException              => println("IO exception");
  }


  var globalMin = 0;

  val nBinary = n.toBinaryString

  val ret = nBinary.foldLeft(0) ((acc, c) =>  c match {
    case '1' => {
      if(acc > globalMin )
        {
          globalMin = acc
        }
      0
    }
    case '0' =>  acc+1;
  }
  )
  return globalMin ;

}

solution(1041)