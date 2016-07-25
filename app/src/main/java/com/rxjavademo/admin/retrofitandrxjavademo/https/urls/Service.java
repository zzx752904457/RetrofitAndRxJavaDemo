package com.rxjavademo.admin.retrofitandrxjavademo.https.urls;


import com.rxjavademo.admin.retrofitandrxjavademo.bean.basebean.Result;
import com.rxjavademo.admin.retrofitandrxjavademo.bean.CityBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2016/7/25.
 */
public interface Service {

    //url: "http://ip.taobao.com/service/getIpInfo.php?ip=202.202.32.202"

    String BASE_URL = "http://ip.taobao.com/";

    String CITY_URL = "service/getIpInfo.php";

    @GET(CITY_URL)
    Observable<Result<CityBean>> getCityDataByRxJava(
            @Query("ip") String ip
    );

    @GET(CITY_URL)
    Call<Result<CityBean>> getCityDataByJava(
            @Query("ip") String ip
    );
}
