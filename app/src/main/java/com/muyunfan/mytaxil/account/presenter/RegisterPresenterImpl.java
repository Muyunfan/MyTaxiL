package com.muyunfan.mytaxil.account.presenter;


import com.muyunfan.mytaxil.account.model.IAccountManager;
import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.account.model.bean.RegisterState;
import com.muyunfan.mytaxil.account.ui.IRegisterView;
import com.muyunfan.mytaxil.common.databus.RegisterBus;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.CommonResponse;

/**
 * 类名称：RegisterPresenterImpl
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/13 15:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class RegisterPresenterImpl implements IRegisterPresenter{

    private IAccountManager manager;
    private IRegisterView view;

    public RegisterPresenterImpl(IAccountManager manager, IRegisterView view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public void register(String phone, String password) {
        manager.register(phone, password);
    }

    @Override
    public void checkUserExist(String phone) {
        manager.checkUserExist(phone);
    }

    @Override
    public void login(String phone, String password) {
        manager.auth(phone, password);
    }

    @RegisterBus
    @Override
    public void onRegisterState(RegisterState state) {

        if (state.getCode() == CommonResponse.STATE_USER_EXIST) {

            view.showUserExist(true);
        } else if (state.getCode() == CommonResponse.STATE_NO_REGISTER){
            view.showUserExist(false);
        } else if (state.getCode() == CommonResponse.STATE_ERROR){

            view.showServerError();

        } else {
            view.showRegisterSuc();
        }
    }
    @RegisterBus
    @Override
    public void onAccountInfo(AccountInfo accountInfo) {
        if (accountInfo.getCode() == CommonResponse.STATE_OK) {
            view.showLoginSuc();
        } else {
            view.showServerError();
        }
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
