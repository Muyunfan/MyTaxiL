package com.muyunfan.mytaxil.common.push;

/**
 * 类名称：MsgType
 * 类描述：消息类型
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class MsgType {
    /**
     * 司机位置变化信息
     */
    public static final  int TYPE_DRIVER_LOCATION = 1;
    /**
     * 订单状态变化
     */
    public static final int TYPE_ORDER = 2;
    protected int type;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
