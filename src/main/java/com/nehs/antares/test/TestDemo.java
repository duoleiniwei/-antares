package com.nehs.antares.test;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一些简单用例
 *
 * @author 12239
 */
public class TestDemo {

    /**
     * Arrays.asList方法注意事项
     */
    static class AsListDemo {
        public static void main(String[] args) {
            /**
             * 使用基本数据类型时，得到的结果是对象本身
             */
            int[] myArray = {1, 2, 3};
            List myList = Arrays.asList(myArray);
            System.out.println(myList.size());//1
            System.out.println(myList.get(0));//数组地址值
//            System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
            int[] array = (int[]) myList.get(0);
            System.out.println(array[0]);//1

            /**
             * 使用包装类或者对象，就可以正常访问
             * 但是不能使用add remove clear方法
             * 因为asList底层是AbstractList,其源码调用以上方法时直接抛出UnsupportedOperationException异常
             */
            Integer[] myArray2 = {4, 5, 6};
            List<Integer> myList2 = Arrays.asList(myArray2);
            System.out.println(myList2.size());//3
            System.out.println(myList2.get(0));//4
            System.out.println(myList2.get(1));//5
        }
    }

    /**
     * Java 线程管理 MXBean
     */
    static class ThreadMxBeanDemo {

        public static void main(String[] args) {
            //获取 Java 线程管理 MXBean
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
            // 遍历线程信息，仅打印线程 ID 和线程名称信息
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
            }
        }

    }

    /**
     * 线程简单实现用例  继承Thread类
     */
    static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadDemo1...");
        }

        public static void main(String[] args) {
            ThreadDemo1 threadDemo1 = new ThreadDemo1();
            threadDemo1.start();
        }
    }

    /**
     * 线程简单实现用例  实现Runnable接口
     */
    static class ThreadDemo2 implements Runnable {
        @Override
        public void run() {
            System.out.println("ThreadDemo2...");
        }

        public static void main(String[] args) {
            new Thread(new ThreadDemo2()).start();

            /**
             * 使用java8函数式编程
             */
            new Thread(() -> {
                System.out.println("ThreadDemo2;;;");
            }).start();
        }
    }

    /**
     * 线程组概念
     */
    static class ThreadGroup {
        public static void main(String[] args) {
            Thread testThread = new Thread(() -> {
                System.out.println("testThread当前线程组名字：" +
                        Thread.currentThread().getThreadGroup().getName());
                System.out.println("testThread线程名字：" +
                        Thread.currentThread().getName());
            });

            testThread.start();
            System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
        }
    }

    /**
     * BLOCKED和RUNNABLE状态
     */
    static class ThreadTrans1 {
        public static void main(String[] args) throws InterruptedException {
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    sleepMethod();
                }
            }, "a");
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    sleepMethod();
                }
            }, "b");
            a.start();
//            Thread.sleep(1000);
            b.start();
            System.out.println(a.getName() + ":" + a.getState());
            System.out.println(b.getName() + ":" + b.getState());
        }

        private static synchronized void sleepMethod() {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * ThreadLocal示例
     */
    static class ThreadLocalDemo implements Runnable {
        private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

        public static void main(String[] args) throws InterruptedException {
            ThreadLocalDemo obj = new ThreadLocalDemo();
            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(obj, "" + i);
                Thread.sleep(new Random().nextInt(1000));
                t.start();
            }
        }

        @Override
        public void run() {
            System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + FORMAT_THREAD_LOCAL.get().toPattern());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //formatter pattern is changed here by thread, but it won't reflect to other threads
            FORMAT_THREAD_LOCAL.set(new SimpleDateFormat());

            System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + FORMAT_THREAD_LOCAL.get().toPattern());
        }
    }

    /**
     * AtomicInteger简单用例
     * 不用对方法进行加锁也可以保证线程安全
     */
    static class AtomicIntegerDemo {
        public static void main(String[] args) {
            AtomicInteger atomicInteger = new AtomicInteger();
            int a = atomicInteger.incrementAndGet();//a=1
            int b = atomicInteger.getAndIncrement();//b=1 两者的区别类似于i++和++i
            System.out.println(atomicInteger);//2
        }
    }
}

