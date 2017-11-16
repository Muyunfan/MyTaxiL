package com.muyunfan.mytaxil.main.ui;


import com.muyunfan.mytaxil.main.model.bean.Driver;
import com.muyunfan.mytaxil.model.bean.Order;

import java.util.List;

/**
 * 类名称：IMainView
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/6 15:49
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IMainView {
    /**
     * 显示号码输入框
     */
    void showPhoneInputDialog();

    /**
     * 显示登录框
     * @param phone
     */
    void showLoginDialog(String phone);

    /**
     * 显示附近的司机
     * @param locations
     */
    void showNearDrivers(List<Driver> locations);

    /**
     * 新增附近的司机
     * @param driver
     */
    void addDriver(Driver driver);

    /**
     * 更新司机
     */
    void updateDriver(Driver driver);

    /**
     * 移除附近的司机
     * @param driver
     */
    void removeDriver(Driver driver);

    /**
     *  显示司机已接单
     * @param data
     */
    void showOrderAccepted(Order.Data data);

    /**
     *  订单取消失败
     */
    void cancelOrderFail();

    /**
     *  订单取消成功
     */
    void cancelOrderSuc();

    /**
     * 司机已到到乘车点
     * @param order
     */
    void showDriverArrived(Order.Data order);

    /**
     *  显示行程中
     * @param data
     */
    void showStroke(Order.Data data);

    /**
     *  显示已经到达终点
     * @param data
     */
    void showArriveEnd(Order.Data data);

    /**
     * 显示取消失败
     */
    void showOrderCancelFail();

    /**
     *  显示支付成功
     */

    void showPaySuc();

    /**
     * 显示支付失败
     */
    void showPayFail();

    /**
     * 显示呼叫成功发出
     */
    void showCallSuc();

    /**
     * 显示呼叫失败
     */
    void showCallFail();
}
