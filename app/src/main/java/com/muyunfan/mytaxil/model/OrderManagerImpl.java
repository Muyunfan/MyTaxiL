package com.muyunfan.mytaxil.model;

import com.google.gson.Gson;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.API;
import com.muyunfan.mytaxil.common.http.CommonHandler;
import com.muyunfan.mytaxil.common.http.CommonRequest;
import com.muyunfan.mytaxil.common.http.CommonResponse;
import com.muyunfan.mytaxil.common.http.HttpConfig;
import com.muyunfan.mytaxil.common.http.IHttpClient;
import com.muyunfan.mytaxil.common.repository.Repository;
import com.muyunfan.mytaxil.model.bean.Order;
import com.muyunfan.mytaxil.model.bean.OrderOptMsg;

import rx.functions.Func1;

/**
 * 类名称：OrderManagerImpl
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/25 15:53
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class OrderManagerImpl implements IOrderManager {
    private static final String TAG = "OrderManagerImpl";
    private IHttpClient httpClient;

    public OrderManagerImpl(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public void cancelOrder(final String id) {

        RxBus.getInstance().chainProcess(new Func1() {


            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.CANCEL_ORDER);
                commonRequest.setBody("id", id );
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                OrderOptMsg msg = new OrderOptMsg();
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    msg.setCode(OrderOptMsg.STATE_CANCEL_SUC);
                } else {
                    msg.setCode(OrderOptMsg.STATE_CANCEL_FAIL);
                }

                return msg;
            }
        });
    }

    @Override
    public void getProcessingOrder() {
        RxBus.getInstance().chainProcess(new Func1() {


            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.GET_PROCESSING_ORDERS);
                commonRequest.setBody("uid", new Repository().getAccountUID());
                CommonResponse response = httpClient.get(commonRequest, new CommonHandler());
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    Order order = new Gson().fromJson(response.getData(), Order.class);
                    return order.getData();
                }
                return null;
            }
        });
    }

    @Override
    public void paySuc(final Order.Data order) {
        RxBus.getInstance().chainProcess(new Func1() {


            @Override
            public Object call(Object o) {
                CommonRequest commonRequest = new CommonRequest(HttpConfig.getCurrentDomain() + API.CANCEL_ORDER);
                commonRequest.setBody("id", order.getOrderId() );
                commonRequest.setBody("state", new Integer(Order.HAS_PAYED ).toString());
                CommonResponse response = httpClient.post(commonRequest, new CommonHandler());
                OrderOptMsg msg = new OrderOptMsg();
                if (response.getStateCode() == CommonResponse.STATE_OK) {
                    msg.setCode(OrderOptMsg.PAY_SUC);
                } else {
                    msg.setCode(OrderOptMsg.PAY_FAIL);
                }

                return msg;
            }
        });
    }
}
