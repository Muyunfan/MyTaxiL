package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.account.model.bean.RegisterState;
import com.muyunfan.mytaxil.common.IbasePresenter;

/**
 * 类名称：IRegisterPresenter
 * 类描述：注册页面表现层
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IRegisterPresenter extends IbasePresenter {
    /**
     *  注册
     */
    void register(String phone, String password);
    /**
     *  用户是否存在
     */
    void checkUserExist(String phone);

    /**
     *  登录
     */

    void login(String phone, String password);
    /**
     *  注册状态
     */
    void onRegisterState(RegisterState state);
    /**
     * 登录状态
     */
    void onAccountInfo(AccountInfo accountInfo);
}
