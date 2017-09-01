package software.analysis.nju.constant;

public interface SparkProperties {
    String SPARK_MASTER = "local[2]";
    String SPARK_APP_NAME = "WIFIProbeData";
    String SPARK_ZOOKEEPER = "hbase.zookeeper.property.clientPort";
    String SPARK_ZOOKEEPER_PORT = "2181";
    String SPARK_ZOOKEEPER_QUORUM = "hbase.zookeeper.quorum";
    String SPARK_ZOOKEEPER_QUORUM_IP = "120.24.238.195";
    String GROUP_DATA_TABLE = "GroupData";
    String SPARK_HBASE_CONF = "/usr/local/apps/hbase-1.3.0/conf/hbase-site.xml";
    String ADDRESS_CF = "Address";
    String PROBEINFO_CF = "probeInfo";
    String DATA_CF = "data";

    String lon = "lon";
    String lat = "lat";
    String mmac = "mmac";
    String probe_id = "probe_id";
    String rate = "rate";
    String wmac = "wmac";
    String dataList = "dataList";
    String wssid = "wssid";
    String record_time = "record_time";
    String addr = "addr";
}
