package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.biz.MyScaleBiz;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class MyScaleBizImpl extends BaseBiz implements MyScaleBiz {
    //获取量表
    @Override
    public void getMyScaleInfor(String patientUuid, String status, String page, String pagecount, final OnLoginListener onLoginListener) {
        mApiService.getMyScaleInfor(patientUuid,status,page,pagecount).enqueue(new Callback<ResultModel<List<MyScaleBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<MyScaleBean>>> call, Response<ResultModel<List<MyScaleBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<MyScaleBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取量表详情信息
    @Override
    public void getScaleDetailsInfor(String paperId, String paperUserId, String userId, final OnLoginListener onLoginListener) {
        mApiService.getScaleDetilsInfor(paperId,paperUserId,userId).enqueue(new Callback<ResultModel<ScaleDetailBean>>() {
            @Override
            public void onResponse(Call<ResultModel<ScaleDetailBean>> call, Response<ResultModel<ScaleDetailBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<ScaleDetailBean>> call, Throwable throwable) {
            onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取量表信息

//    @Override
//    public void getMyScaleInfor(String patientUuid, String status, String page, String pagecount, final OnLoginListener onLoginListener) {
//        mApiService.getMyScaleInfor(patientUuid,status,page,pagecount).enqueue(new Callback<ResultModel<List<MyScaleBean>>>() {
//            @Override
//            public void onResponse(Call<ResultModel<List<MyScaleBean>>> call, Response<ResultModel<List<MyScaleBean>>> response) {
//                if (response.isSuccessful()) {
//                    onLoginListener.onResponse(response.body());
//                } else {
//                    onLoginListener.onFailure(response.body().getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultModel<List<MyScaleBean>>> call, Throwable throwable) {
//                onLoginListener.onFailure(throwable.getMessage());
//            }
//        });
//    }
}











