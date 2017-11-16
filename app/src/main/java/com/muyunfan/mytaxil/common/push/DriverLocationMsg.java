package com.muyunfan.mytaxil.common.push;


import com.muyunfan.mytaxil.main.model.bean.Driver;

/**
 * 类名称：DriverLocationMsg
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/18 15:24
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class DriverLocationMsg extends MsgType {

    Driver data;

    public Driver getData() {
        return data;
    }

    public void setData(Driver data) {
        this.data = data;
    }
}
