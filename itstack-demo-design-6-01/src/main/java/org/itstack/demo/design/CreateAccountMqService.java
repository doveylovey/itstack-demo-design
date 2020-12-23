package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.mq.CreateAccount;

public class CreateAccountMqService {
    public void onMessage(String message) {
        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);
        mq.getNumber();
        mq.getAccountDate();
        // ... 处理自己的业务
    }
}
