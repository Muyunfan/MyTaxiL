package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.account.model.IAccountManager;
import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.account.ui.ILoginView;
import com.muyunfan.mytaxil.common.databus.RegisterBus;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.CommonResponse;

/**
 * 类名称：LoginPresenterImpl
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class LoginPresenterImpl implements ILoginPresenter {
    private IAccountManager manager;
    private ILoginView loginView;
    public LoginPresenterImpl(IAccountManager manager, ILoginView loginView) {
        this.manager = manager;
        this.loginView = loginView;
    }

    @Override
    public void subscribe() {

        RxBus.getInstance().register(this);
    }

    @Override
    public void unSubscribe() {

        RxBus.getInstance().unRegister(this);
    }

    @Override
    public void login(String mPhoneStr, String password) {
        manager.auth(mPhoneStr, password);
    }

    @RegisterBus
    public void onAccountInfo(AccountInfo info){
        if (info.getCode() == CommonResponse.STATE_OK) {
            loginView.showLoginSuc();
        } else if (info.getCode() == CommonResponse.STATE_PW_ERROR) {
            loginView.showPasswordError();
        } else {
            loginView.showServerError();
        }
    }
}
