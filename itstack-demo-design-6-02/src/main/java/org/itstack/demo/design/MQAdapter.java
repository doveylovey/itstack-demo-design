package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MQAdapter {
    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    private static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            // Class 类中的 getMethod(String name, Class<?>... parameterTypes) 方法：第一个参数是需要调用的方法名称，第二个参数为可变的参数类型列表(可以为空)
            Method method = RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class);
            // Method 类的 invoke(Object obj, Object... args) 方法：第一个参数是需要调用该方法的对象，第二个参数为参数列表(可以为空)，返回方法的执行结果
            Object invokeRet = method.invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
