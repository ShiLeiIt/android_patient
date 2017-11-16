package cn.qiyu.magicalcrue_patient.home;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.model.HomeDoctorBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class HomeBizImpl extends BaseBiz implements HomeBiz{

    @Override
    public void getUserMessageInfo(String userId, final OnLoginListener onLoginListener) {
    mApiService.getUserMessageInfo(userId).enqueue(new Callback<HomeNumBean>() {
        @Override
        public void onResponse(Call<HomeNumBean> call, Response<HomeNumBean> response) {
            if(response.isSuccessful())
            {
               onLoginListener.onResponse(response.body());
            }else
                onLoginListener.onFailure(response.message());
        }

        @Override
        public void onFailure(Call<HomeNumBean> call, Throwable throwable) {
            onLoginListener.onFailure(throwable.getMessage());
        }
    });
    }

    @Override
    public void getDoctorInfo(String userId, final OnLoginListener onLoginListener) {

    }

}
