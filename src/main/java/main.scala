/**
  * Created by zurbzh on 2018-01-26.
  */

object main {

  def main(args: Array[String]) {

    val db = "/Users/zurbzh/Desktop/CNN_data/CNN_only_500_0Ns_cnf_cls_check_fake.csv"
    val delimiter = ","
    val an = new analyser(db, delimiter)
    an.generate_kmers()
  }

}