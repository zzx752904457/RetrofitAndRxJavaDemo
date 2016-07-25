package com.rxjavademo.admin.retrofitandrxjavademo.https.callback;

import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;

import rx.Subscriber;

/**
 * Created by admin on 2016/7/25.
 */
public class MyRxJavaSubscriber<T> extends Subscriber<Result<T>> {
    private IRxJavaCallBack<T> iRxJavaCallBack;

    public MyRxJavaSubscriber(IRxJavaCallBack<T> iRxJavaCallBack) {
        this.iRxJavaCallBack = iRxJavaCallBack;
    }



    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        iRxJavaCallBack.onError(e.getMessage()+"", 10000);
    }

    @Override
    public void onNext(Result<T> result) {
        if (result.getErrCode() == 0){
            iRxJavaCallBack.onNext(result.getData());
        }else {
            iRxJavaCallBack.onError("城市信息获取失败", result.getErrCode());
        }
    }

}
