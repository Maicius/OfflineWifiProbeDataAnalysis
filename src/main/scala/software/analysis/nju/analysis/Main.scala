package software.analysis.nju.analysis

import org.apache.hadoop.hbase.filter.{CompareFilter, RegexStringComparator, RowFilter}
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.filter.{CompareFilter, RegexStringComparator}
import org.apache.hadoop.hbase.mapreduce.{TableInputFormat, TableMapReduceUtil}
import org.apache.spark.{SparkConf, SparkContext}
import software.analysis.nju.constant.SparkProperties

object Main {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName(SparkProperties.SPARK_APP_NAME).setMaster(SparkProperties.SPARK_MASTER)

    val scan: Scan = new Scan()
    val sc = new SparkContext(sparkConf)
    val conf = HBaseConfiguration.create()
    conf.set(SparkProperties.SPARK_ZOOKEEPER, SparkProperties.SPARK_ZOOKEEPER_PORT)
    conf.set(SparkProperties.SPARK_ZOOKEEPER_QUORUM, SparkProperties.SPARK_ZOOKEEPER_QUORUM_IP)
    conf.addResource(SparkProperties.SPARK_HBASE_CONF)
    conf.set(TableInputFormat.INPUT_TABLE, SparkProperties.GROUP_DATA_TABLE)

    val rowRegexp = "20170824+[0-9]{10}\\-+[0-9]{3}"
    val filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(rowRegexp))
    scan.setFilter(filter)
    val scan_str= TableMapReduceUtil.convertScanToString(scan)
    conf.set(TableInputFormat.SCAN, scan_str)


  }

}
