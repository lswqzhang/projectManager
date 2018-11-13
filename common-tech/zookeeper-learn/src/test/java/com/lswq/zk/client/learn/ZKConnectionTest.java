package com.lswq.zk.client.learn;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZKConnectionTest {

    private static final byte[] data = new byte[0];

    @Test
    public void zkClientTest() {
        ZKConnection connection = new ZKConnection();

        try {

            connection.connect();

            ZooKeeper zk = connection.zk;

            String root = "/locks";
            String SPLITSTR = "_lock_";
            String lockName = "lswq";
            Stat stat = zk.exists(root, false);
            if (stat == null) {
                // 创建根节点
                connection.create(root, CreateMode.PERSISTENT);
            }


            //创建临时子节点
            String myZnode = connection.create(root + "/" + lockName + SPLITSTR, CreateMode.EPHEMERAL_SEQUENTIAL);

            System.err.println(myZnode);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
