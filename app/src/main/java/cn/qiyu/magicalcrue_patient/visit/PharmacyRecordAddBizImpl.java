package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.biz.PharmacyRecordAddBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyWaybean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/21.
 *  用药方案记录添加
 */

public class PharmacyRecordAddBizImpl extends BaseBiz implements PharmacyRecordAddBiz {

    //添加用药方案记录保存带图片
    @Override
    public void addPharmacyRecordSave(String patientUuid, String drugName, String usaged, String amount, final String remarks, String imageList, final OnLoginListener onLoginListener) {
       mApiService.getPharmacyRecordSave(patientUuid,drugName,usaged,amount,remarks,imageList).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
           @Override
           public void onResponse(Call<ResultModel<AddOutPatientDataSaveBean>> call, Response<ResultModel<AddOutPatientDataSaveBean>> response) {
               if (response.isSuccessful()) {
                   onLoginListener.onResponse(response.body());
               } else {
                   onLoginListener.onFailure(response.body().getMessage());
               }
           }

           @Override
           public void onFailure(Call<ResultModel<AddOutPatientDataSaveBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
           }
       });
    }
    //添加用药方案记录保存不带图片
    @Override
    public void addPharmacyRecordSaveText(String patientUuid, String drugName, String usaged, String amount, final String remarks, final OnLoginListener onLoginListener) {
        mApiService.getPharmacyRecordSaveText(patientUuid,drugName,usaged,amount,remarks).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
            @Override
            public void onResponse(Call<ResultModel<AddOutPatientDataSaveBean>> call, Response<ResultModel<AddOutPatientDataSaveBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<AddOutPatientDataSaveBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }


    //获取用药方式
    @Override
    public void getPharmacyWay(String bianma, String type, final OnLoginListener onLoginListener) {
        mApiService.getPharmacyWay(bianma,type).enqueue(new Callback<ResultModel<List<PharmacyWaybean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<PharmacyWaybean>>> call, Response<ResultModel<List<PharmacyWaybean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<ResultModel<List<PharmacyWaybean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }


}











