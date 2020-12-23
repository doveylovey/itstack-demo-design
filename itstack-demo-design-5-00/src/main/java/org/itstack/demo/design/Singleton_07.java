package org.itstack.demo.design;

/**
 * Effective Java 作者推荐的枚举单例(线程安全)
 * <p>
 * 1、《Effective Java》的作者推荐使⽤枚举⽅式实现单例模式，此种⽅式可能是平时最少⽤到的。
 * 2、此种⽅式解决了最主要的问题：线程安全、⾃由串⾏化、单⼀实例。
 * <p>
 * 这种写法在功能上与共有域⽅法相近，但是它更简洁，⽆偿地提供了串⾏化机制，绝对防⽌对此实例化，即使是⾯对复杂的串⾏化或者反射攻击时。
 * 虽然此种⽅式还没有被⼴泛采⽤，但是单元素的枚举类型已经成为实现单例的最佳⽅法。特别注意：此种⽅式在有继承关系的场景下是不可⽤的。
 */
public enum Singleton_07 {
    INSTANCE;

    public void test() {
        System.out.println("hi~");
    }
}