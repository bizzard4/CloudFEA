/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object CloudFeaEngine {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Cloud FEA Engine").setMaster("local")
    val sc = new SparkContext(conf)
    println(s"Engine started")
    sc.stop()
    println(s"Engine stopped")
  }
}