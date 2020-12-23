package org.itstack.demo.design;

/**
 * 饿汉模式(线程安全)
 * <p>
 * 1、此种⽅式与 {@link Singleton_00} 中实例化 Map 基本⼀致，在程序启动时直接运⾏加载，后续有外部需要使⽤时直接获取即可。
 * 2、此种⽅式并不是懒加载，也就是说，⽆论程序中是否⽤到这个类都会在程序启动之初进⾏创建。
 * 3、此种⽅式导致的问题就像下载个游戏软件，可能游戏地图还没有打开，但程序已经将这些地图全部实例化，在⼿机上最明显的体验就是⼀开游戏内存满了，⼿机卡了，需要换了。
 */
public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }
}
