def solution(h: Array[Int]): Int = {

  var stack:List[Int] = List()
  var block_count = 0

  for(height <- h){
    while ( (!stack.isEmpty) && (height < stack.head) ){
      stack = stack.tail
      block_count += 1
    }

    if(stack.isEmpty || height > stack.head)
      stack = height :: stack
  }
  return  block_count+stack.length
}

println (solution(Array(8,8,5,7,9,8,7,4,8)))

