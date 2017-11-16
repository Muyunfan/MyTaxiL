package com.muyunfan.mytaxil.common.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.utils.LogUtil;

import cn.bmob.push.PushConstants;

/**
 * 类名称：MsgType
 * 类描述：司机位置变化
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class PushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Gson gson = new Gson();
        if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            LogUtil.d("bmob", "客户端收到推送内容："+ intent.getStringExtra("msg"));

            String json = intent.getStringExtra("msg");

            MsgType msg = gson.fromJson(json, MsgType.class);
            if (msg.getType() == MsgType.TYPE_DRIVER_LOCATION) {
                // 司机位置变化消息
                DriverLocationMsg  driverLocationMsg =  gson.fromJson(json, DriverLocationMsg.class);
                RxBus.getInstance().send(driverLocationMsg.getData());
            } else if (msg.getType() == MsgType.TYPE_ORDER) {

               OrderMsg orderMsg = gson.fromJson(json, OrderMsg.class);
                RxBus.getInstance().send(orderMsg.getData());
            }
        }
    }
}
