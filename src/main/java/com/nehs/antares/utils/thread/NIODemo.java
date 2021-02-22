package com.nehs.antares.utils.thread;

import java.nio.ByteBuffer;

/**
 * NIO 简单demo
 */
public class NIODemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("初始limit：" + byteBuffer.limit());
        System.out.println("初始capacity：" + byteBuffer.capacity());
        System.out.println("初始position：" + byteBuffer.position());
        System.out.println("初始mark：" + byteBuffer.mark());

        byteBuffer.put("NioDemo".getBytes());
        System.out.println("==============================");
        System.out.println("put后limit：" + byteBuffer.limit());
        System.out.println("put后capacity：" + byteBuffer.capacity());
        System.out.println("put后position：" + byteBuffer.position());
        System.out.println("put后mark：" + byteBuffer.mark());

        //切换成读模式
        byteBuffer.flip();
        System.out.println("==============================");
        System.out.println("flip后limit：" + byteBuffer.limit());
        System.out.println("flip后capacity：" + byteBuffer.capacity());
        System.out.println("flip后position：" + byteBuffer.position());
        System.out.println("flip后mark：" + byteBuffer.mark());

        //创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];
        // 将读取的数据装进我们的字节数组中
        byteBuffer.get(bytes);
        System.out.println("==============================");
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("get后limit：" + byteBuffer.limit());
        System.out.println("get后capacity：" + byteBuffer.capacity());
        System.out.println("get后position：" + byteBuffer.position());
        System.out.println("get后mark：" + byteBuffer.mark());

        //数据没有真正被清空，只是被遗忘掉了
        byteBuffer.clear();
        System.out.println("==============================");
        System.out.println("clear后limit：" + byteBuffer.limit());
        System.out.println("clear后capacity：" + byteBuffer.capacity());
        System.out.println("clear后position：" + byteBuffer.position());
        System.out.println("clear后mark：" + byteBuffer.mark());
    }
}
