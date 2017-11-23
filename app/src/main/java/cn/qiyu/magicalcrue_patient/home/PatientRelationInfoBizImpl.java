package cn.qiyu.magicalcrue_patient.home;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientRelationInfoBiz;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/19.
 */

public class PatientRelationInfoBizImpl extends BaseBiz implements PatientRelationInfoBiz {
    //获取患者关系列表
    @Override
    public void getPatientRelation(String bianma, String type, final OnLoginListener onLoginListener) {
        mApiService.getPatientRelation(bianma,type).enqueue(new Callback<ResultModel<List<PatientRelationBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<PatientRelationBean>>> call, Response<ResultModel<List<PatientRelationBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<PatientRelationBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取疾病种类列表
    @Override
    public void getDieasesList( final OnLoginListener onLoginListener) {
        mApiService.getDiseasesList("").enqueue(new Callback<ResultModel<List<DiseasesBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<DiseasesBean>>> call, Response<ResultModel<List<DiseasesBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<ResultModel<List<DiseasesBean>>> call, Throwable throwable) {
            onLoginListener.onFailure(throwable.getMessage());
            }
        });

    }
}
