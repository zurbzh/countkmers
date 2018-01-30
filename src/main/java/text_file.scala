import scala.collection.mutable.ListBuffer
import java.io.FileWriter
/**
  * Created by zurbzh on 2018-01-30.
  */
class text_file (db_file:String, delimiter:String, kmer_length:Int, folder:String) {

  val counting = new count(db_file, delimiter, kmer_length)
  val kmers = counting.generate_kmers()
  val extracted_kmer_values = kmers.map(x=> x.map(y=>y._2))
  val column_names = counting.kmers
  val kmers_for_txt = column_names :: extracted_kmer_values

  def writing (): Unit = {
    val txt_name = kmer_length.toString + ".csv"
    val txt = folder.concat(txt_name)
    val fw = new FileWriter(txt, true)
    kmers_for_txt.foreach(x => fw.write(x.mkString(";") + "\n"))
    fw.close()
  }

}
