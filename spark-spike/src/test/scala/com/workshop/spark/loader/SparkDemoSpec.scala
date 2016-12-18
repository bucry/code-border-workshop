package com.workshop.spark.loader

import org.scalatest.FunSuite

/**
  * Created by twcn on 18/12/2016.
  */
class SparkDemoSpec extends FunSuite {

  test("Spark SQL basic example") {
    import org.apache.spark.sql.SparkSession
    val spark = SparkSession
      .builder()
      .master("local[8]")
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    val df = spark.read.json(this.getClass.getClassLoader.getResource("people.json").getPath)
    df.show()
    assert(df.count() == 3)
  }

}
