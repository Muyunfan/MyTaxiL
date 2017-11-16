package com.muyunfan.mytaxil.common.location;

/**
 * 类名称：CommonOnLocationChangeListener
 * 类描述：位置变化监听
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface CommonOnLocationChangeListener {
    void  onLocationChange(double latitude, double longitude, float rotation, String addr);
}
