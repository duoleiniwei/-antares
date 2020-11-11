package com.nehs.antares.utils.thread;

import java.util.concurrent.*;

/**
 * @author 12239
 */
public class CountDownLatchExample1 {
    /**
     * 模拟线程访问次数
     */
    public static final int THREAD_COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    Thread.sleep(500);
                    System.out.println("sbThread"+threadNum);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// 表示一个请求已经被完成
                }
            });
        }
        //终止线程池
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish.....");
    }
}
