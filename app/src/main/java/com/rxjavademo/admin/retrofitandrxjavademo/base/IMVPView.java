package com.rxjavademo.admin.retrofitandrxjavademo.base;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface IMVPView {
    void showProgress();
    void hideProgress();
    void onError(String errMsg, int errCode);
}
