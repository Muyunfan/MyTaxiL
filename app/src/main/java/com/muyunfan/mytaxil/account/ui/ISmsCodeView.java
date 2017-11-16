package com.muyunfan.mytaxil.account.ui;

/**
 * 类名称：ISmsCodeView
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/5 15:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface ISmsCodeView {
    void showLoading();
    void showError();
    void showSendState(boolean suc);

    void showVerifyState(boolean suc);
    void showUserExist(boolean exist);
}
