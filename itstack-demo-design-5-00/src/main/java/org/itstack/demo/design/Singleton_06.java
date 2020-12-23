package org.itstack.demo.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS：AtomicReference(线程安全)
 * <p>
 * 1、Java 并发库提供了很多原⼦类来⽀持并发访问的数据安全性，如：AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference。
 * 2、AtomicReference 可以封装引⽤⼀个 V 实例⽀持并发访问。
 * 3、此种⽅式的好处就是不需要使⽤传统的加锁⽅式保证线程安全，⽽是依赖于 CAS 的忙等算法(依赖于底层硬件的实现)来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞，也就没有了额外的开销，并且可以⽀持较⼤的并发性。
 * 4、此种⽅式也有⼀个缺点就是忙等，如果⼀直没有获取到将会处于死循环中。
 */
public class Singleton_06 {
    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private Singleton_06() {
    }

    public static final Singleton_06 getInstance() {
        for (; ; ) {
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }
}
