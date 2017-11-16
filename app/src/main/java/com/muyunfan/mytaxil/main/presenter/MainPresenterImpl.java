package com.muyunfan.mytaxil.main.presenter;


import com.muyunfan.mytaxil.account.model.IAccountManager;
import com.muyunfan.mytaxil.account.model.bean.AccountInfo;
import com.muyunfan.mytaxil.account.model.bean.NearDrivers;
import com.muyunfan.mytaxil.common.IbasePresenter;
import com.muyunfan.mytaxil.common.databus.RegisterBus;
import com.muyunfan.mytaxil.common.databus.RxBus;
import com.muyunfan.mytaxil.common.http.CommonResponse;
import com.muyunfan.mytaxil.main.model.IMainManager;
import com.muyunfan.mytaxil.main.model.bean.Driver;
import com.muyunfan.mytaxil.main.ui.IMainView;
import com.muyunfan.mytaxil.model.IOrderManager;
import com.muyunfan.mytaxil.model.bean.Order;
import com.muyunfan.mytaxil.model.bean.OrderOptMsg;

/**
 * 类名称：MainPresenterImpl
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 17/3/6 15:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class MainPresenterImpl implements IbasePresenter {


    private IAccountManager loginManager;
    private IMainManager mainManager;
    private IOrderManager orderManager;
    private IMainView view;
    private Order.Data mCurrentOrder;
    private double mCurrentLatitude;
    private double mCurrentLongitude;

    public MainPresenterImpl(IAccountManager loginManager,
                             IMainManager mainManager,
                             IOrderManager orderManager,
                             IMainView view) {
        this.loginManager = loginManager;
        this.mainManager = mainManager;
        this.orderManager = orderManager;
        this.view = view;
    }

    @RegisterBus
    public synchronized void  update(Driver driver) {

        view.addDriver(driver);
    }

    @RegisterBus
    public void onOrderState(Order.Data data) {
        mCurrentOrder = data;
        switch (data.getState()) {

            case Order.ACCEPT:
                view.showOrderAccepted(data);
                break;
            case Order.ONBOARD:
                view.showDriverArrived(data);
                break;
            case Order.STROKE:
                view.showStroke(data);
                break;
            case Order.FINISH:
                view.showArriveEnd(data);
                break;
            default:
                if (mCurrentLatitude != 0 || mCurrentLongitude != 0) {
                    getNearDrivers(mCurrentLatitude, mCurrentLongitude);
                }
                break;
        }
    }

    @RegisterBus
    public void onAccountInfo(AccountInfo info) {
        if (info.getCode() == CommonResponse.STATE_NO_REGISTER) {

            //未注册用户,显示注册页面
            view.showPhoneInputDialog();

        } else if (info.getCode() == CommonResponse.STATE_TOKEN_EXPIRE) {
             //登录过期显示登录页面
            view.showLoginDialog(info.getData().getAccount());
        } else if(info.getCode() == CommonResponse.STATE_NOT_TOKEN_EXPIRE){
            //自动登录
            loginManager.authToken();

        }
    }


    @RegisterBus
    public void onNearDrivers(NearDrivers nearDrivers) {
        if (checkOrderProcessing()) {
            return;
        }
        if (nearDrivers.getCode() == CommonResponse.STATE_OK) {
            view.showNearDrivers(nearDrivers.getData());

        }
    }

    @RegisterBus
    public void onOrderOpt(OrderOptMsg orderOptMsg) {
        switch (orderOptMsg.getCode()) {
            case OrderOptMsg.STATE_CANCEL_SUC:
                view.cancelOrderSuc();
                mCurrentOrder = null;
                break;
            case OrderOptMsg.STATE_CANCEL_FAIL:
                view.showOrderCancelFail();
                break;
            case OrderOptMsg.PAY_SUC:
                view.showPaySuc();
                break;
            case OrderOptMsg.PAY_FAIL:
                view.showPayFail();
                break;
            case OrderOptMsg.STATE_CREATE_SUC:
                view.showCallSuc();
                break;
            case OrderOptMsg.STATE_CREATE_FAIL:
                view.showCallFail();
                break;

        }

    }

    /**
     * 获取进行中订单
     */
    public void getProcessingOrder() {

        orderManager.getProcessingOrder();
    }

    /**
     * 取消呼叫
     */
    public void cancelOrder() {

        if (mCurrentOrder != null) {
            orderManager.cancelOrder(mCurrentOrder.getOrderId());
            mCurrentOrder = null;
        } else {
            view.cancelOrderSuc();
        }

    }
    /**
     *  获取本地帐号信息
     */
    public void getLocalAccount() {

        loginManager.getLocalAccountInfo();
    }

    /**
     * 获取附近的司机
     * @param latitude
     * @param longitude
     */
    public void getNearDrivers(double latitude, double longitude) {
        if (checkOrderProcessing()) {
           return;
        }
        mCurrentLatitude = latitude;
        mCurrentLongitude = longitude;
        mainManager.getNearDrivers(latitude, longitude);
    }

    private boolean checkOrderProcessing() {
        return mCurrentOrder != null && (mCurrentOrder.processing());

    }

    /**
     *  更新自己的位置
     * @param latitude
     * @param longitude
     * @param rotation
     */
    public void updateMyLocation(String key, double latitude, double longitude, float rotation) {
        mainManager.updateMyLocation(key, latitude, longitude, rotation);
    }


    /**
     *  呼叫附近司机
     *
     */
    public void callDrivers(String key, double startLat, double startLon, double endLat, double endLon, String startAddr, String endAddr, float cost) {
        mainManager.callNearDrivers(key, startLat, startLon, endLat, endLon, startAddr, endAddr, cost);
    }
    public void paySuc() {
        orderManager.paySuc(mCurrentOrder);
    }

    @Override
    public void subscribe() {

        RxBus.getInstance().register(this);
    }

    @Override
    public void unSubscribe() {

        RxBus.getInstance().unRegister(this);
    }



}
