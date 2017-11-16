package com.muyunfan.mytaxil.common.databus;

/**
 * 类名称：DataBus
 * 类描述：数据事件总线抽象
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 14:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface DataBus {
    void register(Object subscriber);
    void unRegister(Object subscriber);
    void send(Object data);
}
