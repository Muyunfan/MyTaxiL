package com.muyunfan.mytaxil.account.ui;

/**
 * 类名称：ILoginView
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface ILoginView {
    /**
     * 登录成功
     */
    void showLoginSuc();

    /**
     * 显示／隐藏加载框
     * @param show
     */
    void showOrHideLoading(boolean show);

    /**
     * 显示服务器错误
     */
    void showServerError();
    /**
     *  显示密码错误
     */
    void showPasswordError();
}
