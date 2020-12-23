package org.itstack.demo.design;

/**
 * 懒汉模式(线程安全)
 * <p>
 * 1、此种⽅式是安全的，但由于把锁加到⽅法上后，所有访问都因需要锁占⽤导致资源的浪费。
 * 2、如果不是特殊情况下，不建议此种⽅式实现单例模式。
 */
public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (null != instance) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
