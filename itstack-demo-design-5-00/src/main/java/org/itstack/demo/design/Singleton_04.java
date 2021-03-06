package org.itstack.demo.design;

/**
 * 类的静态内部类(线程安全)
 * <p>
 * 1、此种⽅式既保证了线程安全又保证了懒加载，同时不会因为加锁而耗费性能。
 * 2、这主要是因为 JVM 可以保证多线程并发访问的正确性，也就是⼀个类的构造⽅法在多线程环境下可以被正确的加载。
 * 3、此种⽅式也是⾮常推荐使⽤的⼀种单例模式。
 */
public class Singleton_04 {
    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}
