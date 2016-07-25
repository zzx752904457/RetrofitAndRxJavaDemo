package com.rxjavademo.admin.retrofitandrxjavademo.model;

import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.INormalJavaCallBack;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.IRxJavaCallBack;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.MyNormalJavaCallBack;
import com.rxjavademo.admin.retrofitandrxjavademo.https.callback.MyRxJavaSubscriber;
import com.rxjavademo.admin.retrofitandrxjavademo.https.inithttp.ServiceClient;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;

import retrofit2.Call;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2016/7/25.
 */
public class CityByRxJavaModel {
    public interface Listener{
        void getDataSuccess(CityBean data);
        void onError(String errMsg, int errCode);
    }

    public void getCityDataByRxJava(String ip,final Listener listener) {
        Observable observable = ServiceClient.getService()
                .getCityDataByRxJava(ip)
                //新开线程来进行网络请求
                .subscribeOn(Schedulers.io())
                //在主线程上进行响应
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new MyRxJavaSubscriber(new IRxJavaCallBack<CityBean>() {
            @Override
            public void onNext(CityBean data) {
                listener.getDataSuccess(data);
            }

            @Override
            public void onError(String errMsg, int errCode) {
                listener.onError(errMsg,errCode);
            }
        }));
    }
}
