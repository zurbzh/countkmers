/**
  * Created by zurbzh on 2018-01-26.
  */

object main {

  def main(args: Array[String]) {

    val db = args(0)
    val delimiter = args(1)
    val kmer_length = args(2).toInt
    val folder = args(3)
    val txt = new text_file(db, delimiter, kmer_length, folder)
    txt.writing()
  }

}