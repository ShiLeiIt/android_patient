package cn.qiyu.magicalcrue_patient.register_login;


import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.AppVersionBiz;
import cn.qiyu.magicalcrue_patient.biz.RegisterBiz;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VersionUpdateBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class AppVersionBizImpl extends BaseBiz implements AppVersionBiz {


    @Override
    public void getAppVersionIsUpdate(String patient, String platform, String channel, String current_version, final OnLoginListener onLoginListener) {
        mApiService.getAppVersionIsUpdate(patient,platform,channel,current_version).enqueue(new Callback<ResultModel<VersionUpdateBean>>() {
            @Override
            public void onResponse(Call<ResultModel<VersionUpdateBean>> call, Response<ResultModel<VersionUpdateBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<VersionUpdateBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}
