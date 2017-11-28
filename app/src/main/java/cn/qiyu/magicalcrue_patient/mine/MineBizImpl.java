package cn.qiyu.magicalcrue_patient.mine;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.biz.MineBiz;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class MineBizImpl extends BaseBiz implements MineBiz {

    // 获取用户基本信息
    @Override
    public void getUserInfo(String userUuid, final OnLoginListener onLoginListener) {
       mApiService.getUserInfor(userUuid).enqueue(new Callback<ResultModel<UserInfor>>() {
           @Override
           public void onResponse(Call<ResultModel<UserInfor>> call, Response<ResultModel<UserInfor>> response) {
               if (response.isSuccessful()) {
                   onLoginListener.onResponse(response.body());
               } else {
                   onLoginListener.onFailure(response.body().getMessage());
               }
           }

           @Override
           public void onFailure(Call<ResultModel<UserInfor>> call, Throwable throwable) {
            onLoginListener.onFailure(throwable.getMessage());
           }
       });
    }
    //获取患者基本信息
    @Override
    public void getPatientInfor(String patientUuid, final OnLoginListener onLoginListener) {
        mApiService.getPatientBasicInfor(patientUuid).enqueue(new Callback<ResultModel<PatientInfor>>() {
            @Override
            public void onResponse(Call<ResultModel<PatientInfor>> call, Response<ResultModel<PatientInfor>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<PatientInfor>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }


}
