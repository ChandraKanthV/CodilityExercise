def solution(a: Int, b: Int, k: Int): Int = {
  try{
    if(b < a) throw new IllegalArgumentException("b < a")
    if(! (0 to  2000000000).contains(a)) throw new IllegalArgumentException("a out of rang")
    if(! (0 to  2000000000).contains(b)) throw new IllegalArgumentException("b out of rang")
    if(! (1 to 2000000000).contains(k) ) throw  new IllegalArgumentException("k is Invalid" )
  }
  catch {
    case e:IllegalArgumentException => {
      sys.exit()
    }
  }


  return 0

}
