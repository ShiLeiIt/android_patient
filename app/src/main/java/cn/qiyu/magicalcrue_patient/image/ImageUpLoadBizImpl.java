package cn.qiyu.magicalcrue_patient.image;

import cn.qiyu.magicalcrue_patient.base.ImageBaseBiz;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;


import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/22.
 */

public class ImageUpLoadBizImpl extends ImageBaseBiz implements ImageUpLoadBiz {

    @Override
    public void getImageUpLoad(RequestBody imgs, final OnLoginListener onLoginListener) {
       mApiService.getUpSingleImage(imgs).enqueue(new Callback<ImageUpLoadBean>() {
           @Override
           public void onResponse(Call<ImageUpLoadBean> call, Response<ImageUpLoadBean> response) {
               if (response.isSuccessful()) {
                   onLoginListener.onResponse(response.body());
               } else {
                   onLoginListener.onFailure(response.body().getMessage());
               }
           }

           @Override
           public void onFailure(Call<ImageUpLoadBean> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
           }
       });
    }


}
