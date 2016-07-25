package com.rxjavademo.admin.retrofitandrxjavademo.https.callback;

import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;

import retrofit2.Call;

/**
 * Created by admin on 2016/7/25.
 */
public interface INormalJavaCallBack<T> {
    void onResponse(Call<Result<T>> call, T data);

    void onFailure(String errMsg, int errCode);
}
