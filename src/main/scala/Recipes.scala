import java.io.FileWriter

object Recipes extends App {
  val srcName = "/Users/masha/Desktop/CookBook.txt"
  val dstName = "/Users/masha/Desktop/NewRecipes.txt"

  def openSource(): Seq[String] = {
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq
    filePointer.close()
    myLines

  }

  def processSeq(mySeq:Seq[String]) = {

    val firstSeq = mySeq
      .filter(x => x == x.toUpperCase || x.startsWith(" " * 4))
      .filter(x => x != "")
      .filter(x => !(x contains "*"))
      .filter(x => !(x contains "\""))
      .filter(x => !x.startsWith(" " * 5))
      .filter(x => !x.startsWith("([0-9])"))

    firstSeq

//    var isCapital = false
//    var hasParagraph = false
//    var isLastCapital = false
//
//    var lastString = ""
//    var newSeq: Seq[String] = Seq()
//
//    for (string <- firstSeq) {
//
//      isLastCapital = isCapital
//      isCapital = string.exists(_.isUpper)
//      hasParagraph = string.startsWith("    ")
//
//      do {
//        lastString = hasParagraph(string)
//      }
//
//      if (isLastCapital && hasParagraph == true)
//        println(string)
//      while (string == hasParagraph) string
//      lastString = string
//
//      newSeq
//    }
  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    mySeq.foreach(println)
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n")foreach fw.write
    scala.util.Success
  }

    val mySeq = openSource()
    val filteredSeq= processSeq(mySeq)
    saveSeq(dstName, filteredSeq)

}
