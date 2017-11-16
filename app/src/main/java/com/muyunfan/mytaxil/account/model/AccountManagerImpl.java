package com.muyunfan.mytaxil.account.model;

import com.google.gson.Gson;
import com.muyunfan.mytaxil.DidiApplication;
import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.account.model.bean.RegisterState;
import com.muyunfan.mytaxil.account.model.bean.SmsCodeSendState;
import com.muyunfan.mytaxil.account.model.bean.SmsCodeVerifyState;
import com.muyunfan.mytaxil.common.cache.SharedPreferencesDao;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.API;
import com.muyunfan.mytaxil.common.http.CommonHandler;
import com.muyunfan.mytaxil.common.http.CommonRequest;
import com.muyunfan.mytaxil.common.http.CommonResponse;
import com.muyunfan.mytaxil.common.http.HttpConfig;
import com.muyunfan.mytaxil.common.http.IHttpClient;
import com.muyunfan.mytaxil.common.repository.Repository;
import com.muyunfan.mytaxil.common.utils.SafeUtil;

import rx.functions.Func1;

/**
 * 类名称：AccountManagerImpl
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/4 15:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class AccountManagerImpl implements IAccountManager {
    private static final String TAG = "AccountManagerImpl";
    private IHttpClient httpClient ;
    public AccountManagerImpl(IHttpClient httpClient) {

        this.httpClient = httpClient;
    }

    @Override
    public void auth(final String account, final String pw) {
        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.AUTH);
                String uid = new Repository().getAccountUID();
                commonRequest.setBody("phone", account);
                commonRequest.setBody("password", pw);
                commonRequest.setBody("uid", uid);
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                AccountInfo accountInfo;
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    accountInfo = new Gson().fromJson(response.getData(), AccountInfo.class);
                    saveAccountInfo(response.getData());
                } else {
                    accountInfo = new AccountInfo();
                    accountInfo.setCode(response.getStateCode());
                }

                return accountInfo;
            }
        });

    }

    private void saveAccountInfo(String data) {
        //加密
        String str = SafeUtil.decrypt(data);
        SharedPreferencesDao dao = new SharedPreferencesDao(DidiApplication.getInstance(), SharedPreferencesDao.FILE_USER);
        dao.save(SharedPreferencesDao.KEY_USER, str);

    }

    @Override
    public void authToken() {
        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                AccountInfo info = new Repository().getLocalAccountFromPF();
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.AUTH_TOKEN);
                commonRequest.setBody("token", info.getData().getTokent());
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    info = new Gson().fromJson(response.getData(), AccountInfo.class);
                    saveAccountInfo(response.getData());
                } else {
                    info = new AccountInfo();
                    info.setCode(response.getStateCode());
                }

                return info;
            }
        });
    }

    @Override
    public void register(final String account, final String pw) {

        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.REGISTER);
                commonRequest.setBody("phone", account);
                commonRequest.setBody("password", pw);
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                RegisterState registerState;
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    registerState = new Gson().fromJson(response.getData(), RegisterState.class);
                } else {
                    registerState = new RegisterState();
                    registerState.setCode(response.getStateCode());
                }

                return registerState;
            }
        });
    }

    @Override
    public void isLogin() {

    }

    @Override
    public void getLocalAccountInfo() {

        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                return new Repository().getLocalAccountFromPF();
            }
        });

    }



    @Override
    public void getSmsCode(final String phone) {


        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.GET_SMS_CODE);
                commonRequest.setBody("phone", phone);
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                SmsCodeSendState smsCodeSendState = new SmsCodeSendState();
                smsCodeSendState.setCode(response.getStateCode());
                return smsCodeSendState;
            }
        });


    }

    @Override
    public void verifySmsCode(final String phone, final String code) {
        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.VERIFY_SMS_CODE);
                commonRequest.setBody("phone", phone);
                commonRequest.setBody("code", code);
                CommonResponse response = httpClient.get(commonRequest, new CommonHandler());
                SmsCodeVerifyState smsCodeVerifyState;
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    smsCodeVerifyState = new Gson().fromJson(response.getData(), SmsCodeVerifyState.class);
                } else {
                    smsCodeVerifyState = new SmsCodeVerifyState();
                    smsCodeVerifyState.setCode(response.getStateCode());
                }

                return smsCodeVerifyState;
            }
        });
    }

    @Override
    public void checkUserExist(final String account) {
        RxBus.getInstance().chainProcess(new Func1() {
            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.IS_USER_EXIST);
                commonRequest.setBody("phone", account);

                CommonResponse response = httpClient.get(commonRequest, new CommonHandler());
                RegisterState registerState;
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    try {
                        registerState = new Gson().fromJson(response.getData(), RegisterState.class);
                    } catch (Exception e) {
                        registerState = new RegisterState();
                        registerState.setCode(CommonResponse.STATE_NO_REGISTER);
                    }

                } else {
                    registerState = new RegisterState();
                    registerState.setCode(response.getStateCode());
                }

                return registerState;
            }
        });
    }
}
