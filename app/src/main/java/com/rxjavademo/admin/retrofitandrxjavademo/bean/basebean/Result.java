package com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Result<T> {

    @SerializedName("code")
    private int errCode;

    private T data;


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
