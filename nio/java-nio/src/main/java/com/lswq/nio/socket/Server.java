package com.lswq.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓存的大小可以看到打印输出的变化 
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);//调整缓存的大小可以看到打印输出的变化 

    String str;

    public void start() throws IOException {
        // 打开服务器套接字通道，单例模式
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 服务器配置为非阻塞 
        ssc.configureBlocking(false);
        // 通过open()方法找到Selector
        selector = SelectorProvider.provider().openSelector();
        // 将channel注册到selector中,并将channel设置成等待新的连接
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 进行服务的绑定 
        ssc.bind(new InetSocketAddress("localhost", 8001));

        while (!Thread.currentThread().isInterrupted()) {
            System.err.println("selector");
            // select()阻塞，等待有事件发生唤醒
            // 等待处理新的事件;
            // 一直阻塞直到下一个事件到来才唤醒.
            // 此方法执行处于阻塞模式的选择操作。
            // 仅在至少选择一个通道、调用此选择器的 wakeup 方法，或者当前的线程已中断（以先到者为准）后此方法才返回。
            selector.select();
            System.err.println("selector…………");
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (!key.isValid()) {
                    System.err.println("check……");
                    continue;
                }
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                } else if (key.isWritable()) {
                    write(key);
                }
                keyIterator.remove(); //该事件已经处理，可以丢弃
            }
        }
    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("write:" + str);

        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        sendBuffer.flip();
        channel.write(sendBuffer);
        channel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // Clear out our read buffer so it's ready for new data 
        this.readBuffer.clear();
        // readBuffer.flip();
        // Attempt to read off the channel 
        int numRead;
        try {
            numRead = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            // The remote forcibly closed the connection, cancel 
            // the selection key and close the channel. 
            key.cancel();
            socketChannel.close();

            return;
        }

        str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("a new client connected " + clientChannel.getRemoteAddress());
    }

    public static void main(String[] args) throws IOException {
        System.out.println("server started...");
        new Server().start();
    }
}
