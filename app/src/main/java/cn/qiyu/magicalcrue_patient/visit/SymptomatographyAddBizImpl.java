package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.biz.SymptomatographyAddBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/22.
 *  添加症状记录
 */

public class SymptomatographyAddBizImpl extends BaseBiz implements SymptomatographyAddBiz {

    //添加门诊信息保存带图片
    @Override
    public void addSymptomatographySave(String patientUuid, String symptomCode, String symptom, final String remarks, String imageList, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getSymptomatographySave(patientUuid,symptomCode,symptom,remarks,imageList).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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
    //添加门诊信息保存带图片
    @Override
    public void addSymptomatographySaveText(String patientUuid, String symptomCode, String symptom, String remarks, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getSymptomatographySaveText(patientUuid,symptomCode,symptom,remarks).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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
}











