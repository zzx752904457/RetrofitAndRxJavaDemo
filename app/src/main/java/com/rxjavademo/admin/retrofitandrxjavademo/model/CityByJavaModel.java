package com.rxjavademo.admin.retrofitandrxjavademo.model;

import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.INormalJavaCallBack;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.MyNormalJavaCallBack;
import com.rxjavademo.admin.retrofitandrxjavademo.https.inithttp.ServiceClient;

import retrofit2.Call;

/**
 * Created by admin on 2016/7/25.
 */
public class CityByJavaModel {
    public interface Listener{
        void getDataByJavaSuccess(CityBean data);
        void onFailure(String errMsg, int errCode);
    }

    public void getCityDataByJava(String ip, final Listener listener){
        Call<Result<CityBean>> call = ServiceClient.getService().getCityDataByJava(ip);
        call.enqueue(new MyNormalJavaCallBack<CityBean>(new INormalJavaCallBack<CityBean>() {
            @Override
            public void onResponse(Call<Result<CityBean>> call, CityBean data) {
                listener.getDataByJavaSuccess(data);
            }

            @Override
            public void onFailure(String errMsg, int errCode) {
                listener.onFailure(errMsg,errCode);
            }
        }));
    }
}
