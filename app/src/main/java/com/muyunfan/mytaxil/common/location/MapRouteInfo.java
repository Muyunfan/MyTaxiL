package com.muyunfan.mytaxil.common.location;

/**
 * 类名称：MapRouteInfo
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:22
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class MapRouteInfo {
    private float distance;
    private float taxiCost;
    private int duration;

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTaxiCost() {
        return taxiCost;
    }

    public void setTaxiCost(float taxiCost) {
        this.taxiCost = taxiCost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
