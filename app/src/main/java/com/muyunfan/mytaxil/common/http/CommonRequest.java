package com.muyunfan.mytaxil.common.http;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：CommonRequest
 * 类描述：封装 HTTP 通用的请求信息
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 14:42
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class CommonRequest {
    private String url;
    private Map<String, String> header;
    private Map<String, Object> body;

    public CommonRequest(String url) {
        this.url = url;
        header = new HashMap();
        body = new HashMap<>();
        //通用头部
        header.put("X-Bmob-Application-Id", HttpConfig.getCurrentAppID());
        header.put("X-Bmob-REST-API-Key", HttpConfig.getCurrentAppKey());

    }

    public void setHeader(String key, String value) {
        header.put(key, value);
    }

    public void setBody(String key, String value) {
        body.put(key, value);
    }

    public String getJsonBody() {

        return new Gson().toJson(this.body, HashMap.class);

    }
    public String getLineParam(){
        for (String key : body.keySet()) {


            url = url.replace("${" + key + "}", body.get(key).toString());

        }
        return url;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public String getUrl() {
        return url;
    }
}
