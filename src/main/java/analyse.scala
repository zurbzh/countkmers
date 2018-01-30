/**
  * Created by zurbzh on 2018-01-26.
  */


import scala.collection.mutable.{ArrayBuffer, ListBuffer}


class analyser (db_file:String, delimiter:String) {


  val df = db_creation.receive(db_file, delimiter)
  df.registerTempTable("data")

  val sequence = df.select("sequence")
  val sequences_as_list =  sequence.rdd.map(r => r.getString(0)).collect()


  val kmer_length = 3
  val letters = "ACGT"
  def comb(s:String)=(s * s.length).combinations(kmer_length)
  val kmers = comb(letters).flatMap(_.toString.permutations.toList).toList




  val kmer_list = ListBuffer[List[(String, Int)]]()




  def generate_kmers () {

    for (seq <- sequences_as_list) {
      val count = seq.sliding(kmer_length).toSeq.groupBy(identity).mapValues(_.size).toMap

      val counted_kmers_by_sequence = kmers.map(kmer =>
        if (count.contains(kmer))
          (kmer, count(kmer))
        else
          (kmer, 0))

      kmer_list ++= List(counted_kmers_by_sequence)

    }
  }


}
