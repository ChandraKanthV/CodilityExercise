import  util.control.Breaks._
val a = 1
val b = 4

var a1 =a
var b1 =b

var Amax = 0
var Bmax =0

val sLength:Int = a+b
var finalString = ""

for (i <- (0 until sLength)){


  if( (b1 >=a1) && (Bmax != 2)){
    finalString += "b"
    Bmax +=1
    b1 -=1
  }
  else  if( (b1 <= a1) && (Amax != 2)){
    finalString += "a"
    Amax +=1
    a1 -=1
  }
  else {
    println("lkjfj")

    if( (Amax ==2) && (b1>0) && (Bmax <= 2))
    {
      Amax = 0
      finalString += "b"
      b1 -=1
    }


    else if ((Bmax ==2) && (a1>0) && (Amax <= 2))
    {
      Bmax = 0
      finalString += "a"
      a1 -=1
    }
    else {
      if((a1 == 1) && (b==0)){
        finalString +="a"
      }
      else if((b1==1) && (a1==0)){
        finalString +="b"
      }
    }



  }
}

