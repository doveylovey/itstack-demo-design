package org.itstack.demo.desgin.factory;

import org.itstack.demo.desgin.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器实现类：每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象
 * 参考 https://blog.csdn.net/jiankunking/article/details/52143504
 */
public class JDKInvocationHandler implements InvocationHandler {
    /**
     * 需要代理的真实对象
     */
    private ICacheAdapter cacheAdapter;

    /**
     * 构造方法：给需要代理的真实对象赋初值
     *
     * @param cacheAdapter
     */
    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用。调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理真实对象前还可以做一些其他操作
        System.out.println("代理真实对象前，要干点啥呢？");

        // 获取每个参数所对应的类型
        Class<?>[] clazzByArgs = ClassLoaderUtils.getClazzByArgs(args);
        // 通过方法名称、方法参数构造一个 Method 对象
        Method desMethod = ICacheAdapter.class.getMethod(method.getName(), clazzByArgs);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的 handler 对象的 invoke 方法来进行调用
        Object result = desMethod.invoke(cacheAdapter, args);

        // 在代理真实对象后也可以做一些其他操作
        System.out.println("代理真实对象后，要干点啥呢？");
        return result;
    }
}
