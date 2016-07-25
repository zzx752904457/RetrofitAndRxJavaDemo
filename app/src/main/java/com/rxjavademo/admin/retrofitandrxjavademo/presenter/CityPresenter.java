package com.rxjavademo.admin.retrofitandrxjavademo.presenter;

import com.rxjavademo.admin.retrofitandrxjavademo.view.interfaces.ICityView;
import com.rxjavademo.admin.retrofitandrxjavademo.base.MVPPresenter;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;
import com.rxjavademo.admin.retrofitandrxjavademo.model.CityModel;

/**
 * Created by admin on 2016/7/25.
 */
public class CityPresenter extends MVPPresenter<ICityView> implements CityModel.Listener{


    private CityModel cityModel;

    public CityPresenter() {
        cityModel = new CityModel();
    }


    /**
     * 用rxJava请求城市接口数据
     */
    public void getCityDataByRxJava(){
        getView().showProgress();
        cityModel.getCityDataByRxJava(this);
    }

    /**
     * 用普通java请求城市接口数据
     */
    public void getCityDataByJava(){
        getView().showProgress();
        cityModel.getCityDataByJava(this);
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

}
