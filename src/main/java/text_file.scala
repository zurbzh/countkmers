import scala.collection.mutable.ListBuffer
import java.io.FileWriter
/**
  * Created by zurbzh on 2018-01-30.
  */
class text_file (db_file:String, delimiter:String, kmer_length:Int, file_location:String) {

  val counting = new count(db_file, delimiter, kmer_length)
  val kmers = counting.generate_kmers()

  def writing (): Unit = {
    val txt_name = kmer_length.toString + ".txt"
    val txt = file_location.concat(txt_name)
    val fw = new FileWriter(txt, true)
    kmers.foreach(x => x.map(y=> fw.write(y._1.mkString(",") + "\n")))
  }

}
