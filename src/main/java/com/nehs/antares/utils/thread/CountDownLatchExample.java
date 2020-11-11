package com.nehs.antares.utils.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 12239
 */
public class CountDownLatchExample {
    /**
     * 模拟线程访问次数
     */
    public static final int THREAD_COUNT = 100;
    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;
    /**
     * 容量
     */
    private static final int QUEUE_CAPACITY = 100;
    /**
     * 等待时间
     */
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,//等待时间的单位为 TimeUnit.SECONDS
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),//任务队列为ArrayBlockingQueue，并且容量为 100
                new ThreadPoolExecutor.CallerRunsPolicy());//饱和策略

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            try {
                //执行Runnable
                executor.execute(worker);
//                Thread.sleep(100);
//                System.out.println("sbThread"+i);
//                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //表示一个请求已完成
                countDownLatch.countDown();
            }
        }
        //终止线程池
        executor.shutdown();
        countDownLatch.await();
        System.out.println("finish.....");
    }
}
