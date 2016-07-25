package com.rxjavademo.admin.retrofitandrxjavademo.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rxjavademo.admin.retrofitandrxjavademo.R;


/**
 * Created by Administrator on 2016/4/17.
 */
public abstract class MVPActivity<V extends IMVPView,P extends MVPPresenter<V>> extends AppCompatActivity implements IMVPView{


    protected P mPresenter;
    private ProgressDialog progressDialog;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * 在onCreate里对presenter进行初始化
         */
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
        progressDialog = new ProgressDialog(getContext());
        super.onCreate(savedInstanceState);
    }

    protected Context getContext(){
        return this;
    }

    /**
     * 创建presenter类
     */
    @NonNull
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onError(String errMsg,int errCode) {
        Toast.makeText(getContext() , errMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("加载中");
        progressDialog.setMessage("正在请求数据");
        progressDialog.setIcon(R.mipmap.ic_launcher); // 设置进度条的图标
        progressDialog.setIndeterminate(false); // 设置进度条是否为不明确
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }
}
