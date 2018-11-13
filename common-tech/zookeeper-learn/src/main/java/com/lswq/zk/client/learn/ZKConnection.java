package com.lswq.zk.client.learn;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZKConnection {
    /**
     * server列表, 以逗号分割
     */
    protected String hosts = "192.168.15.220:2181,192.168.15.221:2181,192.168.15.222:2181";
    /**
     * 连接的超时时间, 毫秒
     */
    private static final int SESSION_TIMEOUT = 5000;

    private static final byte[] data = new byte[0];

    private CountDownLatch connectedSignal = new CountDownLatch(1);

    protected ZooKeeper zk;

    /**
     * 连接zookeeper server
     */
    public void connect() throws Exception {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new ConnWatcher());
        // 等待连接完成
        connectedSignal.await();
    }

    private class ConnWatcher implements Watcher {
        public void process(WatchedEvent event) {
            // 连接建立, 回调process接口时, 其event.getState()为KeeperState.SyncConnected
            if (event.getState() == Event.KeeperState.SyncConnected) {
                // 放开闸门, wait在connect方法上的线程将被唤醒
                connectedSignal.countDown();
            }
        }
    }


    /**
     * 创建临时节点
     */
    public String create(String nodePath, CreateMode mode) throws Exception {
        return zk.create(nodePath, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, mode);
    }


}
