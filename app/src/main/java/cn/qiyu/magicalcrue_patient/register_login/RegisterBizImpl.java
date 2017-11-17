package cn.qiyu.magicalcrue_patient.register_login;


import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.RegisterBiz;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class RegisterBizImpl extends BaseBiz implements RegisterBiz {

    @Override
    public void getVerifyInformation(String PhoneNum, final OnLoginListener onLoginListener) {
        mApiService.getVerifyInformation(PhoneNum).enqueue(new Callback<ResultModel<RegisterLoginVerBean>>() {
            @Override
            public void onResponse(Call<ResultModel<RegisterLoginVerBean>> call, Response<ResultModel<RegisterLoginVerBean>> response) {
                if(response.isSuccessful())
                {
                   onLoginListener.onResponse(response.body());
                }else
                    onLoginListener.onFailure(response.message());
            }

            @Override
            public void onFailure(Call<ResultModel<RegisterLoginVerBean>> call, Throwable throwable) {

            }
        });
    }
}
