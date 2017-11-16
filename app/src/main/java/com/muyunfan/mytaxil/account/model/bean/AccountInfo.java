package com.muyunfan.mytaxil.account.model.bean;


import com.muyunfan.mytaxil.common.BaseBean;

/**
 * 类名称：AccountInfo
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/2 15:30
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class AccountInfo extends BaseBean {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String account;
        private String token;
        private String uid;
        public long getExpired() {
            return expired;
        }

        public void setExpired(long expired) {
            this.expired = expired;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        private long expired;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getTokent() {
            return token;
        }

        public void setTokent(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

}
