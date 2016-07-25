package com.rxjavademo.admin.retrofitandrxjavademo.https.callback;

import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2016/7/25.
 */
public class MyNormalJavaCallBack<T> implements Callback<Result<T>> {
    private INormalJavaCallBack<T> iNormalJavaCallBack;

    public MyNormalJavaCallBack(INormalJavaCallBack<T> iNormalJavaCallBack) {
        this.iNormalJavaCallBack = iNormalJavaCallBack;
    }

    @Override
    public void onResponse(Call<Result<T>> call, Response<Result<T>> response) {
        Result<T> result = response.body();
        if (result.getErrCode() == 0){
            iNormalJavaCallBack.onResponse(call, result.getData());
        }else {
            iNormalJavaCallBack.onFailure("城市信息获取失败", result.getErrCode());
        }
    }

    @Override
    public void onFailure(Call<Result<T>> call, Throwable t) {
        iNormalJavaCallBack.onFailure(t.getMessage()+"", 10000);
    }
}
