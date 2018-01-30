/**
  * Created by zurbzh on 2018-01-26.
  */

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.types._

object db_creation {


  val sparkConf = new SparkConf()
    .setAppName("ClusterScore")
    .setMaster("local[2]")
  val sc = new SparkContext(sparkConf)
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)
  import sqlContext.implicits._


  def receive (file_name:String, delimiter:String):DataFrame = {

    val schema = new StructType()
      .add(StructField("id", StringType, true))
      .add(StructField("sequence", StringType, true))
      .add(StructField("label", IntegerType, true))



    val csv = sc.textFile(file_name)
    val data = csv.map(line => line.split(delimiter).map(_.trim))
    val rdd = data.map(row => Row(row(0), row(1), row(2).toInt))

    val df = sqlContext.createDataFrame(rdd, schema)
    return df

  }


}
