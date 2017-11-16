package com.muyunfan.mytaxil.common.repository;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.muyunfan.mytaxil.DidiApplication;
import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.common.cache.SharedPreferencesDao;
import com.muyunfan.mytaxil.common.http.CommonResponse;
import com.muyunfan.mytaxil.common.utils.DevUtil;
import com.muyunfan.mytaxil.common.utils.SafeUtil;

/**
 * 类名称：MsgType
 * 类描述：本地数据仓库
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class Repository {
    public AccountInfo getLocalAccountFromPF(){
        SharedPreferencesDao dao = new SharedPreferencesDao(DidiApplication.getInstance(), SharedPreferencesDao.FILE_USER);
        String encrytString = dao.get(SharedPreferencesDao.KEY_USER);
        AccountInfo info;
        if (encrytString != null) {
            //解密
            String json = SafeUtil.decrypt(encrytString);
            info = new Gson().fromJson(json, AccountInfo.class);

            if (System.currentTimeMillis()  > info.getData().getExpired()) {

                // token 过期
                info.setCode(CommonResponse.STATE_TOKEN_EXPIRE);
            } else {
                info.setCode(CommonResponse.STATE_NOT_TOKEN_EXPIRE);
            }


        } else {
            info = new AccountInfo();
            info.setCode(CommonResponse.STATE_NO_REGISTER);
        }

        return info;
    }

    public String getAccountUID() {
        AccountInfo info = getLocalAccountFromPF();
        String uid = null;
        if (info != null && info.getData() != null) {
            uid = info.getData().getUid();
        }
        if (TextUtils.isEmpty(uid)) {
            uid = DevUtil.getRandomUUID();
        }
        return uid;
    }
}
