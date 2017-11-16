package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.account.model.bean.SmsCodeSendState;
import com.muyunfan.mytaxil.account.model.bean.SmsCodeVerifyState;
import com.muyunfan.mytaxil.common.IbasePresenter;

/**
 * 类名称：ISmsCodePresenter
 * 类描述：验证码输入界面表现逻辑层
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface ISmsCodePresenter extends IbasePresenter {
    void getSmsCode(String phone);
    void verifySmsCode(String phone, String code);
    void isUserExist(String phone);
    void onSmsSendState(SmsCodeSendState smsCodeSendState);
    void onSmsCodeVerifyState(SmsCodeVerifyState smsCodeVerifyState);

}
