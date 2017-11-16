package com.muyunfan.mytaxil.model.bean;


import com.muyunfan.mytaxil.common.BaseBean;

/**
 * 类名称：OrderOptMsg
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/25 15:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class OrderOptMsg extends BaseBean {
    public static final int STATE_CANCEL_SUC = 1;
    public static final int STATE_CANCEL_FAIL = -1;
    public static final int PAY_SUC = 2;
    public static final int PAY_FAIL = -2;
    public static final int STATE_CREATE_FAIL = -3;
    public static final int STATE_CREATE_SUC = 3;
}
