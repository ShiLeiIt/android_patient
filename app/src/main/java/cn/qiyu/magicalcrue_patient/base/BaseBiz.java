package cn.qiyu.magicalcrue_patient.base;

import cn.qiyu.magicalcrue_patient.Api.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/13.
 */

public class BaseBiz {
    public ApiService mApiService;
    public BaseBiz() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }
}
