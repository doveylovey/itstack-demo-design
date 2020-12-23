package org.itstack.demo.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态类
 * <p>
 * 1、此种⽅式在平常的业务开发中很常⻅，静态类的⽅式可以在第⼀次运⾏时直接初始化 Map 类，不需要延迟加载再使⽤。
 * 2、在不需要维持任何状态，仅仅⽤于全局访问时，使⽤静态类的⽅式更加⽅便。
 * 3、但如果需要被继承以及需要维持⼀些特定状态的情况下，就适合使⽤单例模式。
 */
public class Singleton_00 {
    public static Map<String, String> cache = new ConcurrentHashMap<>();
}
