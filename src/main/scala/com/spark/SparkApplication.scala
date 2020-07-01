package com.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkApplication {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("First Spark Application")
    val sc = new SparkContext(conf)
    val rdd1 = sc.makeRDD(Array(100, 200, 400, 250))
    rdd1.collect().foreach(println)
  }
}
