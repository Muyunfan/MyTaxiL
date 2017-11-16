package com.muyunfan.mytaxil.common.location;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

/**
 * 类名称：IMapServiceLayer
 * 类描述：地图的抽象接口
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:20
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface IMapServiceLayer {

    /**
     *  获取一个地图视图
     */
    View getMap();

    /**
     *  设置蓝点样式图标
     */
    void setLocationStyle(Bitmap bitmap);
    /**
     *  添加标记
     */
    void addMarker(String key,Bitmap bitmap, double latitude, double longitude, float rotation);

    /**
     *  添加自己位置的标记
     */

    void addMyLocationMarker(Bitmap bitmap, double latitude, double longitude);

    /**
     * 更新标记
     */

    void updateMarker(String key,Bitmap bitmap, double latitude, double longitude, float rotation);

    /**
     *   移除标记
     */
    boolean removeMarker(String key);
    /**
     *  移除所有标记
     */

    void clearAllMarker();

    /**
     *  位置变化监听
     */
    void setLocationChangeListener(CommonOnLocationChangeListener listener);

    /**
     *  获取当前城市
     */
    String getCity();

    /**
     * 联动搜索附近的位置
     */
    void poiSearch(String key, OnSearchedListener listener);

    /**
     *  移动相机到点
     */

    void moveCamera(LocationInfo locationInfo, int scale);

    /**
     *  移动相机到范围
     */
    void moveCamera(LocationInfo locationInfo1, LocationInfo locationInfo2);

    /**
     * 驾车线路规划
     */

    void driverRoute(LocationInfo start, LocationInfo end, int color, OnRouteCompleteListener listener);

    /**
     * 生命周期函数定义
     * @param
     */

    void onCreate(Bundle savedState);

    void onResume();

    void onPause();

    void onDestroy();
}
