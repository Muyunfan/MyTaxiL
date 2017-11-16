package com.muyunfan.mytaxil.account.ui;

/**
 * 类名称：IRegisterView
 * 类描述：注册页面
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IRegisterView {
    /**
     * 显示／隐藏加载图表
     * @param show
     */
    void showOrHideLoading(boolean show);

    /**
     *  显示注册成功
     */
    void showRegisterSuc();
    /**
     * 显示自动登录成功
     */
    void showLoginSuc();
    /**
     *  显示用户已经存在
     */
    void showUserExist(boolean exist);
    /**
     * 显示服务器繁忙
     */
    void showServerError();

}
