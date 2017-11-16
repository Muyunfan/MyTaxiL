package com.muyunfan.mytaxil.model;


import com.muyunfan.mytaxil.model.bean.Order;

/**
 * 类名称：IOrderManager
 * 类描述：订单相关模块
 * 创建人：L.C.W
 * 创建时间：on 17/3/25 15:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IOrderManager {
    /**
     *  取消订单
     */
    void cancelOrder(String id);

    /**
     *  获取进行中的订单
     */

    void getProcessingOrder();

    void paySuc(Order.Data mCurrentOrder);
}
