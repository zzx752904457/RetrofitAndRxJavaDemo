package com.rxjavademo.admin.retrofitandrxjavademo.https.urls;


import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by admin on 2016/7/25.
 */
public interface Service {

    String BASE_URL = "http://ip.taobao.com/";

    String CITY_URL = "service/getIpInfo.php?ip=202.202.32.202";

    @GET(CITY_URL)
    Observable<Result<CityBean>> getCityData();

    @GET(CITY_URL)
    Call<Result<CityBean>> getCityData2();
}
