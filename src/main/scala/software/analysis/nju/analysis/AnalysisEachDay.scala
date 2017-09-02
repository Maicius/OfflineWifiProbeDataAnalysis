package software.analysis.nju.analysis

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.SparkContext
import software.analysis.nju.constant.SparkProperties
import software.analysis.nju.util.ParseJSON
import software.analysis.nju.bean.macDataBean
object AnalysisEachDay {
  def analysisStayTime(sc: SparkContext, conf: Configuration): Unit = {
    val hBaseRDD = sc.newAPIHadoopRDD(conf, classOf[TableInputFormat],
      classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable],
      classOf[org.apache.hadoop.hbase.client.Result])
    val count = hBaseRDD.count()
    hBaseRDD.foreach { case (_, result) => {
      //println(result)
      val dataList = Bytes.toString(result.getValue(SparkProperties.DATA_CF, SparkProperties.dataList))
      val macList = ParseJSON.jsonToList(dataList)
      println(macList)
      val probeId = Bytes.toString(result.getValue(SparkProperties.PROBEINFO_CF, SparkProperties.probe_id))
      val mmac = Bytes.toString(result.getValue(SparkProperties.PROBEINFO_CF, SparkProperties.mmac))
      val rate = Bytes.toString(result.getValue(SparkProperties.PROBEINFO_CF, SparkProperties.rate))
      val record_time = Bytes.toString(result.getValue(SparkProperties.PROBEINFO_CF, SparkProperties.record_time))
      val wmac = Bytes.toString(result.getValue(SparkProperties.PROBEINFO_CF, SparkProperties.wssid))
      val addr = Bytes.toString(result.getValue(SparkProperties.ADDRESS_CF, SparkProperties.addr))
      val dataIterator = macList.iterator()
      while(dataIterator.hasNext){

      }
      println("RDDCOUNT:" + count)
    }
    }

  }
}
