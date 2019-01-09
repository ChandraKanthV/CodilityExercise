
val a = Array(-30,4,1, 20, -10, 3 , 2)

  var max3vals:Array[Int] = Array.fill(3)(Int.MinValue)
  var min2vls:Array[Int] = Array.fill(2)(Int.MaxValue)

  for (i <- a) {
      if (i < min2vls(0)) {
        min2vls(1) = min2vls(0)
        min2vls(0) = i
      }
      else if (i < min2vls(1)) min2vls(1) = i

      if (i > max3vals(2)) {
        max3vals(0) = max3vals(1)
        max3vals(1) = max3vals(2)
        max3vals(2) = i
      }
      else  if(i>max3vals(1)){
        max3vals(0) = max3vals(1)
        max3vals(1) = i
      }
      else if(i > max3vals(0)) max3vals(0) = i


  }

println(max3vals.toList)
println(min2vls.toList)

print (math.max(
  (min2vls(0)*min2vls(1)*max3vals(2)),
  (max3vals(0)*max3vals(1)*max3vals(2))
  ))
