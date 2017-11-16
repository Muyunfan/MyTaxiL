package com.muyunfan.mytaxil;

import android.app.Application;

import com.muyunfan.mytaxil.common.http.HttpConfig;
import com.squareup.leakcanary.LeakCanary;

import c.b.BP;
import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobInstallation;

/**
 * 类名称：DidiApplication
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/4 15:54
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class DidiApplication extends Application {
    private static DidiApplication instance;
    private String pushClientId;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        HttpConfig.useTestConfig();
        initBmob();
        initPush();
        BP.init(HttpConfig.getCurrentAppID());
        instance = this;
    }

    /**
     *  初始化 bmob 配置
     */
    private void initBmob() {
        BmobConfig config = new BmobConfig.Builder(this)
                .setApplicationId(HttpConfig.getCurrentAppID())
                .setConnectTimeout(30)
                .build();
        Bmob.initialize(config);
    }

    /**
     *  初始化推送服务
     */
    private void initPush() {


        // 使用推送服务时的初始化操作
        BmobInstallation installation = BmobInstallation.getCurrentInstallation();
        installation.save();
        pushClientId = installation.getInstallationId();

        // 启动推送服务
        BmobPush.setDebugMode(true);
        BmobPush.startWork(this);

    }

    public String getPushClientId() {
        return pushClientId;
    }

    public static DidiApplication getInstance() {
      return  instance;
    };
}
