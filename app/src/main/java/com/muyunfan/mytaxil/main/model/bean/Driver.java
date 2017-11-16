package com.muyunfan.mytaxil.main.model.bean;

/**
 * 类名称：Driver
 * 类描述：位置
 * 创建人：L.C.W
 * 创建时间：on 17/3/4 15:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class Driver {
    private double latitude;
    private double longitude;
    private float rotation;
    private String key;
    public void setRotation(float rotation) {
        this.rotation = rotation;
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

    public float getRotation() {
        return rotation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
