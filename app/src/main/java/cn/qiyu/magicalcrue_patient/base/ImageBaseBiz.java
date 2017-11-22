package cn.qiyu.magicalcrue_patient.base;

import cn.qiyu.magicalcrue_patient.Api.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ShiLei on 2017/11/22.
 */

public class ImageBaseBiz {
    public ApiService mApiService;
    public ImageBaseBiz() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.IMAGE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }
}
