package com.muyunfan.mytaxil.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类名称：ToastUtil
 * 类描述：Toast 工具类
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class ToastUtil {
    public static void show(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
