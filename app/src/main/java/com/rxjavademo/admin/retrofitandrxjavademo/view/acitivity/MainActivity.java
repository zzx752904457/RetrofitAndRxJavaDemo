package com.rxjavademo.admin.retrofitandrxjavademo.view.acitivity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjavademo.admin.retrofitandrxjavademo.view.interfaces.ICityView;
import com.rxjavademo.admin.retrofitandrxjavademo.R;
import com.rxjavademo.admin.retrofitandrxjavademo.base.MVPActivity;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;
import com.rxjavademo.admin.retrofitandrxjavademo.presenter.CityPresenter;

public class MainActivity extends MVPActivity<ICityView, CityPresenter> implements ICityView {
    private final String ip = "202.202.32.202";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.tv);
        TextView tv2 = (TextView) findViewById(R.id.tv2);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getCityDataByRxJava(ip);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getCityDataByJava(ip);
            }
        });
    }

    @NonNull
    @Override
    protected CityPresenter createPresenter() {
        return new CityPresenter();
    }

    @Override
    public void getCityDataSuccess(CityBean bean) {
        Toast.makeText(getContext(), bean.getCountry() + "-" + bean.getArea() + "\n" + bean.getCity() + "-" + bean.getIsp(), Toast.LENGTH_SHORT).show();
    }
}
