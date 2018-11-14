package com.lswq.zk.client.learn;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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


    @Test
    public void hashDelete() {
        Map<String, String> testOne = new HashMap<>();
        testOne.put("a", "a");
        testOne.put("b", "b");
        testOne.put("c", "c");
        testOne.put("d", "d");
        Iterator<Map.Entry<String, String>> entry = testOne.entrySet().iterator();
        while (entry.hasNext()) {
            Map.Entry<String, String> next = entry.next();
            System.err.println(next.getKey());
            entry.remove();
        }

        Map<String, String> testTwo = new HashMap<>();
        testTwo.put("a", "a");
        testTwo.put("b", "b");
        testTwo.put("c", "c");
        testTwo.put("d", "d");

        Iterator<String> key = testTwo.keySet().iterator();
        // ConcurrentModificationException
        while (key.hasNext()) {
            String next = key.next();
            System.err.println(next);
            testTwo.remove(next);
        }
    }
 }
