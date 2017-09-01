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


    byte[] ADDRESS_CF = "Address".getBytes();
    byte[] PROBEINFO_CF = "probeInfo".getBytes();
    byte[] DATA_CF = "data".getBytes();

    byte[] lon = "lon".getBytes();
    byte[]  lat = "lat".getBytes();
    byte[]  mmac = "mmac".getBytes();
    byte[]  probe_id = "probe_id".getBytes();
    byte[]  rate = "rate".getBytes();
    byte[]  wmac = "wmac".getBytes();
    byte[]  dataList = "dataList".getBytes();
    byte[]  wssid = "wssid".getBytes();
    byte[] record_time = "record_time".getBytes();
    byte[]  addr = "addr".getBytes();

    long DEFAULT_FIRST_VISIT_TIME = 0L;
}
