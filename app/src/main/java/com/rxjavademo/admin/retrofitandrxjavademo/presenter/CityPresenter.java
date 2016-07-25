package com.rxjavademo.admin.retrofitandrxjavademo.presenter;

import com.rxjavademo.admin.retrofitandrxjavademo.model.CityByJavaModel;
import com.rxjavademo.admin.retrofitandrxjavademo.view.interfaces.ICityView;
import com.rxjavademo.admin.retrofitandrxjavademo.base.MVPPresenter;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;
import com.rxjavademo.admin.retrofitandrxjavademo.model.CityByRxJavaModel;

/**
 * Created by admin on 2016/7/25.
 */
public class CityPresenter extends MVPPresenter<ICityView> implements CityByRxJavaModel.Listener,CityByJavaModel.Listener {


    private CityByRxJavaModel cityByRxJavaModel;
    private CityByJavaModel cityByJavaModel;

    public CityPresenter() {
        cityByRxJavaModel = new CityByRxJavaModel();
        cityByJavaModel = new CityByJavaModel();
    }


    /**
     * 用rxJava请求城市接口数据
     */
    public void getCityDataByRxJava(String ip) {
        getView().showProgress();
        cityByRxJavaModel.getCityDataByRxJava(ip, this);
    }

    /**
     * 用普通java请求城市接口数据
     */
    public void getCityDataByJava(String ip) {
        getView().showProgress();
        cityByJavaModel.getCityDataByJava(ip, this);
    }

    @Override
    public void getDataSuccess(CityBean data) {
        //如果activity和view已经解除绑定，就不要再走activity里的回调方法
        if (!isViewAttach()) return;
        getView().hideProgress();
        getView().getCityDataSuccess(data);
    }

    @Override
    public void onError(String errMsg, int errCode) {
        if (!isViewAttach()) return;
        getView().hideProgress();
        getView().onError(errMsg, errCode);
    }

    @Override
    public void getDataByJavaSuccess(CityBean data) {
        //如果activity和view已经解除绑定，就不要再走activity里的回调方法
        if (!isViewAttach()) return;
        getView().hideProgress();
        getView().getCityDataSuccess(data);
    }

    @Override
    public void onFailure(String errMsg, int errCode) {
        if (!isViewAttach()) return;
        getView().hideProgress();
        getView().onError(errMsg, errCode);
    }
}
