package cloudfea.converter

import com.amazonaws._
import com.amazonaws.auth._
import com.amazonaws.services.s3._
import com.amazonaws.services.s3.model._
import stlfilereader._

import scala.io.Source

/**
 * Convert a STL file to a point cloud file. All storing in done in Amazon S3.
 * args[0] Aws key
 * args[1] Aws secret key
 * args[2] S3 file url
 */
object CloudFeaConverter extends App { 
    println("Converting order for " + args(2))
    
    val bucket_name = "cloudfea.parts"
    
    val credentials = new BasicAWSCredentials(args(0), args(1)) 
    val client = new AmazonS3Client(credentials)
    
    if (client.doesObjectExist(bucket_name, args(2))) {
      println("Part found, starting converting")
      
      val obj = client.getObject(new GetObjectRequest(bucket_name, args(2)))
      println("Object recovered")
      
      val stlReader = new StlTextReader()
      val stlobject = stlReader.createStlObject(obj.getObjectContent)
      println(stlobject)   
    }
}