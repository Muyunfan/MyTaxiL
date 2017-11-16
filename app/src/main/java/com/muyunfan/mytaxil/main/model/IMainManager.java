package com.muyunfan.mytaxil.main.model;

/**
 * 类名称：IMainManager
 * 类描述：主页面业务逻辑层
 * 创建人：L.C.W
 * 创建时间：on 17/3/4 15:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IMainManager {
    /**
     *  获取附近司机
     */
    void getNearDrivers(double latitude, double longitude);

    /**
     *  更新我的位置
     */

    void updateMyLocation(String key, double latitude, double longitude, float rotation);

    /**
     *  呼叫附近司机
     */
    void callNearDrivers(String key, double startLatitude, double startLongitude, double endLatitude, double endLongitude, String startAddr, String endAddr, float cost);
}
