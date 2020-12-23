package org.itstack.demo.design;

/**
 * 懒汉模式(线程不安全)
 * <p>
 * 1、单例模式有⼀个特点就是不允许外部直接创建对象，也就是 new Singleton_01()，因此这⾥在默认的构造函数上添加了 private 。
 * 2、此种⽅式的单例满⾜了懒加载，但如果有多个访问者同时去获取对象实例(你可以想象成⼀堆⼈在抢厕所)，就会造成多个相同实例并存，从⽽没有达到单例的要求。
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        if (null != instance) {
            return instance;
        }
        instance = new Singleton_01();
        return instance;
    }
}
