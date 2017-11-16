package com.muyunfan.mytaxil.common.push;


import com.muyunfan.mytaxil.model.bean.Order;

/**
 * 类名称：MsgType
 * 类描述：消息类型
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class OrderMsg extends MsgType {
    private Order.Data data;

    public Order.Data getData() {
        return data;
    }

    public void setData(Order.Data data) {
        this.data = data;
    }
}
