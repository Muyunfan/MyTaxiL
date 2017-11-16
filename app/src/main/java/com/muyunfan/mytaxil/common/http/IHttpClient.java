package com.muyunfan.mytaxil.common.http;

/**
 * 类名称：IHttpClient
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 14:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface IHttpClient {
    CommonResponse get(CommonRequest request, CommonHandler handler);
    CommonResponse post(CommonRequest request, CommonHandler handler);
}
