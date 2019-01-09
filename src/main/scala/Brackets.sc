//import scala.collection.immutable.Stack
//Stcak is perecate so use list as stack

def solution(s: String): Int = {

  val startsParanth:Set[Char] = Set('(','[','{')
  var stack : List[Char] = List()

  for( c <- s) c match {
    case e if startsParanth contains e => stack = List(e) ::: stack
    case ')' => {if(stack.isEmpty || stack.head != '(' ) return 0 else stack=stack.tail}
    case ']' => {if(stack.isEmpty || stack.head != '[' ) return 0 else stack=stack.tail}
    case '}' => {if(stack.isEmpty || stack.head != '{' ) return 0 else stack=stack.tail}
    case _ =>
  }

  if(stack.length ==0) return  1 else 0
}


println(solution(""))