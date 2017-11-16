package com.muyunfan.mytaxil.account.model.bean;


import com.muyunfan.mytaxil.common.BaseBean;
import com.muyunfan.mytaxil.main.model.bean.Driver;

import java.util.List;

/**
 * 类名称：NearDrivers
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/15 15:34
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class NearDrivers extends BaseBean {
    private List<Driver> data;

    public List<Driver> getData() {
        return data;
    }

    public void setData(List<Driver> data) {
        this.data = data;
    }
}
