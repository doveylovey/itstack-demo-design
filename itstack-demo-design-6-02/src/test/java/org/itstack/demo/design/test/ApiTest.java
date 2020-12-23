package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.MQAdapter;
import org.itstack.demo.design.OrderAdapterService;
import org.itstack.demo.design.RebateInfo;
import org.itstack.demo.design.cuisine.impl.InsideOrderService;
import org.itstack.demo.design.cuisine.impl.POPOrderAdapterServiceImpl;
import org.itstack.demo.design.mq.CreateAccount;
import org.itstack.demo.design.mq.OrderMq;
import org.itstack.demo.design.mq.POPOrderDelivered;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ApiTest {
    @Test
    public void test_Reflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        Class<? extends RebateInfo> clazz = rebateInfo.getClass();//RebateInfo.class;
        // 通过 Class 对象中的方法名称、参数类型列表获取 Method 对象
        Method method = clazz.getMethod("setUserId", new Class[]{String.class});
        // 调用方法，赋值
        Object invoke = method.invoke(rebateInfo, "123456");
        System.out.println(JSON.toJSONString(rebateInfo));
        System.out.println(JSON.toJSONString(invoke));

        Method method2 = clazz.getMethod("getUserId");
        Object invoke1 = method2.invoke(rebateInfo);
        System.out.println(JSON.toJSONString(invoke1));
    }

    @Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2021-01-01 00:00:00");

        CreateAccount createAccount = new CreateAccount();
        createAccount.setNumber("100001");
        createAccount.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        createAccount.setAccountDate(parse);
        createAccount.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(createAccount.toString(), link01);
        System.out.println("mq.createAccount(适配前)" + createAccount.toString());
        System.out.println("mq.createAccount(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));

        System.out.println("");

        POPOrderDelivered popOrderDelivered = new POPOrderDelivered();
        popOrderDelivered.setuId("100003");
        popOrderDelivered.setOrderId("10333333333333333");
        popOrderDelivered.setOrderTime(parse);
        popOrderDelivered.setSku(parse);
        popOrderDelivered.setSkuName(parse);
        popOrderDelivered.setDecimal(BigDecimal.TEN);

        HashMap<String, String> link03 = new HashMap<>();
        link03.put("userId", "uId");
        link03.put("bizId", "orderId");
        link03.put("bizTime", "orderTime");
        link03.put("desc", "skuName");
        RebateInfo rebateInfo03 = MQAdapter.filter(popOrderDelivered.toString(), link03);
        System.out.println("mq.popOrderDelivered(适配前)" + popOrderDelivered.toString());
        System.out.println("mq.popOrderDelivered(适配后)" + JSON.toJSONString(rebateInfo03));
    }

    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }
}
