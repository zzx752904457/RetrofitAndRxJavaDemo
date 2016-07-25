package com.rxjavademo.admin.retrofitandrxjavademo.view.interfaces;

import com.rxjavademo.admin.retrofitandrxjavademo.base.IMVPView;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;

/**
 * Created by admin on 2016/7/25.
 */
public interface ICityView extends IMVPView{
    void getCityDataSuccess(CityBean bean);
}
