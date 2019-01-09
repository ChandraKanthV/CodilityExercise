import java.io.{BufferedReader, InputStream, InputStreamReader}

def process(in: InputStream ): String /* Either Long */ = {
  val inputStreamReader = new InputStreamReader(in)
  val bufferedReader = new BufferedReader(inputStreamReader)
  Iterator continually bufferedReader.readLine takeWhile (_ != null) mkString

  return "10"
}

val in = new InputStream {
  override def read(): Int = ???
}
println(process())
