/**
  * Created by zurbzh on 2018-01-26.
  */

object main {

  def main(args: Array[String]) {

    val db = "/Users/zurbzh/Desktop/CNN_data/CNN_only_500_0Ns_cnf_cls_check_fake.csv"
    val delimiter = ","
    val kmer_length = 3
    val folder = "/Users/zurbzh/Desktop/CNN_data/"
    val sm = new text_file(db, delimiter, kmer_length, folder)
    sm.writing()
  }

}