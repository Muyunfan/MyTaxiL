package com.muyunfan.mytaxil.account.model;

/**
 * 类名称：IAccountManager
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/2/25 15:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public interface IAccountManager {

    /**
     * 用户登录验证
     * @param account
     * @param pw
     */
    void auth(String account, String pw);

    /**
     *  token 认证
     *
     */
    void authToken();
    /**
     * 用户注册
     * @param account
     * @param pw
     */
    void register(String account, String pw);

    /**
     * 判断登录态
     */
    void isLogin();

    /**
     * 获取本地用户信息
     * @return
     */
    void getLocalAccountInfo();

    /**
     *  获取短信验证码
     */

    void getSmsCode(String phone);
    /**
     *  验证短信验证码
     */
    void verifySmsCode(String phone, String code);
    /**
     *  判断用户是否存在
     */

    void checkUserExist(String phone);
}
