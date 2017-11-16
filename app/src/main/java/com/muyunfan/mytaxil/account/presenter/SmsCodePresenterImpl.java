package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.account.model.IAccountManager;
import com.muyunfan.mytaxil.account.model.bean.RegisterState;
import com.muyunfan.mytaxil.account.model.bean.SmsCodeSendState;
import com.muyunfan.mytaxil.account.model.bean.SmsCodeVerifyState;
import com.muyunfan.mytaxil.account.ui.ISmsCodeView;
import com.muyunfan.mytaxil.common.databus.RegisterBus;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.CommonResponse;

/**
 * 类名称：SmsCodePresenterImpl
 * 类描述：短信验证码
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class SmsCodePresenterImpl implements ISmsCodePresenter {

    private ISmsCodeView view;
    private IAccountManager manager;

    public SmsCodePresenterImpl(ISmsCodeView view, IAccountManager manager) {
        this.view = view;
        this.manager = manager;
    }

    @RegisterBus
    @Override
    public void onSmsSendState(SmsCodeSendState smsCodeSendState) {
        if (smsCodeSendState.getCode() == CommonResponse.STATE_OK) {
            view.showSendState(true);
        } else {
            view.showSendState(false);
        }
    }

    @RegisterBus
    @Override
    public void onSmsCodeVerifyState(SmsCodeVerifyState smsCodeVerifyState) {
        view.showVerifyState(smsCodeVerifyState.getCode() == CommonResponse.STATE_OK);
    }
    @RegisterBus
    public void onRegisterState(RegisterState registerState) {
        view.showUserExist(registerState.getCode() == CommonResponse.STATE_USER_EXIST);
    }

    @Override
    public void getSmsCode(String phone) {


        manager.getSmsCode(phone);

    }

    @Override
    public void verifySmsCode(String phone, String code) {
        manager.verifySmsCode(phone, code);
    }

    @Override
    public void isUserExist(String phone) {
        manager.checkUserExist(phone);
    }


    @Override
    public void subscribe() {

        RxBus.getInstance().register(this);
    }

    @Override
    public void unSubscribe() {

        RxBus.getInstance().unRegister(this);

    }
}
