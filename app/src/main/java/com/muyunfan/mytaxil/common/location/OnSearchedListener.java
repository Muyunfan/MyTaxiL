package com.muyunfan.mytaxil.common.location;

import java.util.List;

/**
 * 类名称：OnSearchedListener
 * 类描述：POI 搜索结果监听器
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 15:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface OnSearchedListener {
    void onSearched(List<LocationInfo> results);

    void onError(int rCode);
}
