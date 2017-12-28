package cn.qiyu.magicalcrue_patient.home;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.fragment.HomePageFragment;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeDoctorBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class HomeBizImpl extends BaseBiz implements HomeBiz {
    //首页数目
    @Override
    public void getUserMessageInfo(String userId, final OnLoginListener onLoginListener) {
        mApiService.getUserMessageInfo(userId).enqueue(new Callback<ResultModel<HomeNumBean>>() {
            @Override
            public void onResponse(Call<ResultModel<HomeNumBean>> call, Response<ResultModel<HomeNumBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else
                    onLoginListener.onFailure(response.body().getMessage());
            }


            @Override
            public void onFailure(Call<ResultModel<HomeNumBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });


    }

    @Override
    public void getDoctorQRcode(String patientUuid, String DoctorUuid, final OnLoginListener onLoginListener) {
        mApiService.getDoctorQRcode(patientUuid,DoctorUuid).enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable throwable) {
            onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取医生团队信息
    @Override
    public void getDoctorTeamInfor(String patientId, final OnLoginListener onLoginListener) {

//        Log.i("patientId", patientId);
        mApiService.getDoctorTeamInfor(patientId).enqueue(new Callback<ResultModel<DoctorTeamBean>>() {
            @Override
            public void onResponse(Call<ResultModel<DoctorTeamBean>> call, Response<ResultModel<DoctorTeamBean>> response) {
                if (response.isSuccessful()) {
//                    Log.i("doctorTeamName", response.body().getData().getTeam_name());
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<DoctorTeamBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取首页Banner
    @Override
    public void getHomeBanner(String type, final OnLoginListener onLoginListener) {
        mApiService.getHomeBanner(type).enqueue(new Callback<ResultModel<List<HomeBannerBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<HomeBannerBean>>> call, Response<ResultModel<List<HomeBannerBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                    Log.i("banner===","chenggong");
                } else {
                    Log.i("banner===","shibai");
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<ResultModel<List<HomeBannerBean>>> call, Throwable throwable) {
                Log.i("banner===","qingqiushibai");
                onLoginListener.onFailure(throwable.getMessage());
            }
        });

    }


}
