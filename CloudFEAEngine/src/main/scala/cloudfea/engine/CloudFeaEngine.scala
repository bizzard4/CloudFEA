package cloudfea.engine

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/**
 * Spark engine object.
 */
object CloudFeaEngine {
  
  private val conf = new SparkConf().setAppName("Cloud FEA Engine").setMaster("local")
  private val sc = new SparkContext(conf)
  
  /**
   * Engine main.
   * args[0] = access key
   * args[1] = secret access key
   */
  def main(args: Array[String]) {  
    println(s"Engine started")
    
    // Setup aws secret
    sc.hadoopConfiguration.set("fs.s3n.awsAccessKeyId", args(0))
    sc.hadoopConfiguration.set("fs.s3n.awsSecretAccessKey", args(1))
    
    val myStlPart = sc.textFile("s3n://cloudfea.parts/Cube.STL")
    myStlPart.collect().foreach(println)
   
    
    sc.stop()
    println(s"Engine stopped")
  }
}