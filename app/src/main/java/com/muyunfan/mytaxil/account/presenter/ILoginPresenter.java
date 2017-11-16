package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.common.IbasePresenter;

/**
 * 类名称：ILoginPresenter
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface ILoginPresenter extends IbasePresenter {
    /**
     * 登录
     * @param mPhoneStr
     * @param password
     */
    void login(String mPhoneStr, String password);
}
