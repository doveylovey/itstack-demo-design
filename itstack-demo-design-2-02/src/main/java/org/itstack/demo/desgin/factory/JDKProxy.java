package org.itstack.demo.desgin.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {
    /**
     * 获取代理对象
     *
     * @param interfaceImpl
     * @param cacheAdapter
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> interfaceImpl, ICacheAdapter cacheAdapter) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = interfaceImpl.getInterfaces();
        // JDKInvocationHandler 实现了 InvocationHandler 接口，主要实现了方法调用从代理类到委托类的分派转发。
        // 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用。
        // 即：要代理哪个真实对象，就将该对象传进去，最后通过该真实对象来调用其方法。
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        // 为指定的类加载器、一组接口、调用处理器生成动态代理类实例
        Object proxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{interfaces[0]}, handler);
        return (T) proxyInstance;
    }
}
