package com.rxjavademo.admin.retrofitandrxjavademo.https.callback;

/**
 * Created by admin on 2016/7/25.
 */
public interface IRxJavaCallBack<T> {
    void onNext(T data);
    void onError(String errMsg, int errCode);
}
