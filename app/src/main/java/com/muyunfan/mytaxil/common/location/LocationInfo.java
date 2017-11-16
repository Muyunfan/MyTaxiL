package com.muyunfan.mytaxil.common.location;

/**
 * 类名称：LocationInfo
 * 类描述：位置信息
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class LocationInfo {
    private String  name;
    private double  latitude;
    private double longitude;

    public LocationInfo(String name, double latitude, double longtitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
