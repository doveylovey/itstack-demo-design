package org.itstack.demo.design.pay.mode;

/**
 * 支付模式接口
 */
public interface IPayMode {
    /**
     * 安全校验方法
     *
     * @param uId 用户 id
     * @return
     */
    boolean security(String uId);
}
