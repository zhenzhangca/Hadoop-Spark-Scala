package retail_db

import org.apache.spark.{SparkConf, SparkContext}

object GetRevenuePerOrder {
  def main(args: Array[String]): Unit = {
    //SparkConf object
    val conf = new SparkConf().
      setMaster(args(0)). //args(0): excution mode
      setAppName("Get revenue per order")
    //SparkContext object
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val orderItems = sc.textFile(args(1)) //get RDD, args(1): input path
    val revenuePerOrder = orderItems.
      map(oi => (oi.split(",")(1).toInt, oi.split(",")(4).toFloat)).
      reduceByKey(_ + _). //reduce values by same key in dataset
      map(oi => oi._1 + "," + oi._2)

    revenuePerOrder.saveAsTextFile(args(2)) //args(2): output path
  }

}
